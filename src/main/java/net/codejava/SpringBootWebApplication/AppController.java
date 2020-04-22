package net.codejava.SpringBootWebApplication;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Validation.CardValidator;
import entities.Admin;
import entities.Card;
import entities.CardModel;
import entities.Order;
import entities.StockItem;
import entities.User;
import models.CartModel;
import models.CommentModel;
import models.OrderModel;
import models.StockItemModel;
import models.UserModel;
import services.ItemService;
import services.OrderService;
import services.UserService;
import sorting.SortByCategory;
import sorting.SortByManufacturer;
import sorting.SortByName;
import sorting.SortByPrice;
import sorting.SortingContext;

@Controller
public class AppController {
	@Autowired
	private UserService userservice;
	@Autowired
	private StockItemModel itemRepo;
	@Autowired
	private ItemService itemservice;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderModel orderrepo;
	@Autowired
	private CartModel cartRepo;
	@Autowired
	private CommentModel commentRepo;
	@Autowired
	private CardModel cardRepo;

	private UserModel userRepository;
	private HttpSession session;
	private ArrayList<StockItem> items = new ArrayList<>();

	@Autowired
	CardValidator cardValidator = new CardValidator();

	/// INDEX
	@GetMapping(value = "/index")
	public String home() {
		return "index";
	}

	/// VERIFY LOGIN
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String name, @RequestParam String password, HttpServletRequest request,
			Model model) {
		User user = userservice.login(name, password);

		UserType user1;

		if (user != null) {
			int id;
			User loggedInUser = user;
			id = loggedInUser.getId();
			model.addAttribute(name, user.getName());
			System.out.print(loggedInUser.getId());

			request.getSession().setAttribute("user", loggedInUser);
			session = request.getSession(true);
			user1 = new User();
			return user1.login();
		} else if (name.equals("Admin") && password.equals("password")) {
			user1 = new Admin();
			request.getSession().setAttribute("admin", name);
			return user1.login();
		} else {
			model.addAttribute("loginError", "Error logging in, please try again");
			return "login";
		}
	}

	// LOGIN
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}

	// ADDING
	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		StockItem item = new StockItem();
		item.setTitle("First item");
		return "Saved";
	}

	// ALL
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	/// SEARCH PRODUCTS
	@RequestMapping(value = "/searchProducts", method = RequestMethod.GET)
	public String searchProducts(Model model, @RequestParam("keyword") String keyword, HttpServletRequest request,
			@RequestParam String style, @RequestParam String type) {
		ArrayList<StockItem> items = new ArrayList<>();

		System.out.println("here " + itemservice.getAllItems().size());
		SortingContext context = new SortingContext();
		for (int i = 0; i < itemservice.getAllItems().size(); i++) {
			if (type.equalsIgnoreCase("title")) {
				if (itemservice.getAllItems().get(i).getTitle().contains(keyword)) {
					items.add(itemservice.getAllItems().get(i));
				}
				context.setSortingMethod(new SortByName());
				if (style.equalsIgnoreCase("Ascending")) {
					context.ascendingSort(items);
				} else if (style.equalsIgnoreCase("Descending")) {
					context.descendingSort(items);
				}

			}
		}
		for (int i = 0; i < itemservice.getAllItems().size(); i++) {
			if (type.equalsIgnoreCase("category")) {
				if (itemservice.getAllItems().get(i).getCategory().contains(keyword)) {
					items.add(itemservice.getAllItems().get(i));
				}
				context.setSortingMethod(new SortByCategory());
				if (style.equalsIgnoreCase("Ascending")) {
					context.ascendingSort(items);
				} else if (style.equalsIgnoreCase("Descending")) {
					context.descendingSort(items);
				}

			}
		}
		for (int i = 0; i < itemservice.getAllItems().size(); i++) {
			if (type.equalsIgnoreCase("price")) {
				Double usedPrice = Double.parseDouble(keyword);
				if (itemservice.getAllItems().get(i).getPrice().equals(usedPrice)) {
					items.add(itemservice.getAllItems().get(i));
				}
				context.setSortingMethod(new SortByPrice());
				if (style.equalsIgnoreCase("Ascending")) {
					context.ascendingSort(items);
				} else if (style.equalsIgnoreCase("Descending")) {
					context.descendingSort(items);
				}

			}
		}
		for (int i = 0; i < itemservice.getAllItems().size(); i++) {
			if (type.equalsIgnoreCase("manufacturer")) {
				if (itemservice.getAllItems().get(i).getManufacturer().equals(keyword)) {
					items.add(itemservice.getAllItems().get(i));
				}
				context.setSortingMethod(new SortByManufacturer());
				if (style.equalsIgnoreCase("Ascending")) {
					context.ascendingSort(items);
				} else if (style.equalsIgnoreCase("Descending")) {
					context.descendingSort(items);
				}
			}
		}
		System.out.println(items.size());

		model.addAttribute("lists", items);
		String userName = (String) request.getSession().getAttribute("admin");
		if (userName != null) {
			if (userName.equalsIgnoreCase("Admin")) {
				return "viewItems";
			}
		}
		return "cart";
	}

	/// ALL CUSTOMERS
	@RequestMapping(value = "/allCustomers", method = RequestMethod.POST)
	public String customerDetails(HttpServletRequest request, Model model) {
		final ArrayList<User> customersArrayList;
		customersArrayList = (ArrayList<User>) userservice.getAllUsers();
		UserList custsList = new UserList(customersArrayList);
		ArrayList<User> listAll = new ArrayList<User>();
		for (Iterator iterator = custsList.getIterator(); iterator.hasNext();) {
			User name = (User) iterator.next();
			String userName = name.getName();
			String email = name.getEmail();
			String password = name.getPassword();
			String address = name.getAddress();
			User user1 = new User(userName, email, password, address);
			listAll.add(user1);

		}
		for (int i = 0; i < listAll.size(); i++) {
			System.out.println(listAll.get(i).getEmail());
		}
		model.addAttribute("allUsers", listAll);
		System.out.println(listAll.size());
		request.getSession().setAttribute("allUsers", listAll);
		return "customerDetails";
	}

	@RequestMapping(value = "/orderDetails", method = RequestMethod.POST)
	public String orderDetails(HttpServletRequest request, Model model, @RequestParam String email) {
		User u = userservice.getEmail(email);
		final ArrayList<Order> ordersArrayList;
		final ArrayList<Order> orders = new ArrayList<>();

		for (int i = 0; i < u.getOrders().size(); i++) {
			orders.add(u.getOrders().get(i));
		}
		ordersArrayList = (ArrayList<Order>) orderService.getAllOrders();

		OrderHistory history = new OrderHistory((ArrayList<Order>) orders);
		ArrayList<Order> listAll = new ArrayList<Order>();
		for (Iterator iterator = history.getIterator(); iterator.hasNext();) {

			Order order = (Order) iterator.next();
			String name = order.getName();
			Order order1 = new Order(name);
			listAll.add(order1);

		}

		model.addAttribute("allOrders", listAll);
		System.out.println(listAll.size());
		request.getSession().setAttribute("allOrders", listAll);
		return "orderDetails";
	}

	@RequestMapping(value = "/viewItems", method = RequestMethod.POST)
	public String viewItems(HttpServletRequest request, Model model) {
		ArrayList<StockItem> items = new ArrayList<>();
		items = (ArrayList<StockItem>) itemservice.getAllItems();
		model.addAttribute("lists", items);
		return "viewItems";
	}

	@RequestMapping(value = "/viewComments", method = RequestMethod.POST)
	public String viewComments(HttpServletRequest request, Model model, @RequestParam(value = "itemId") int id) {
		ArrayList<StockItem> items = new ArrayList<>();
		items = (ArrayList<StockItem>) itemservice.getAllItems();
		String comment = "";

		StockItem item = itemservice.getItem(id);
		for (int i = 0; i < item.getComments().size(); i++) {
			comment = comment + item.getComments().get(i).getContent() + "\n";
		}
		model.addAttribute("comment", comment);
		return "viewComments";
	}

	@RequestMapping("/AddItemsPage")
	public String addItems(HttpServletRequest request) {
		final ArrayList<User> customersArrayList;
		customersArrayList = (ArrayList<User>) userservice.getAllUsers();
		return "AdminAdd";
	}

	@RequestMapping(value = "/AddItem", method = RequestMethod.POST)
	public String addItem(@RequestParam String name, @RequestParam String category, @RequestParam String manufacturer,
			@RequestParam int quantity, @RequestParam Double price, @RequestParam File pic,
			HttpServletRequest request) {
		boolean state = false;
		StockState noStockState = new OutStock();
		StockState hasStockState = new InStock();
		if (quantity <= 0) {
			state = noStockState.stateOfStock();
			request.setAttribute("state", state);
			System.out.println("out of stock" + state);
		} else {
			state = hasStockState.stateOfStock();
			request.setAttribute("state", state);
		}

		StockItem item = new StockItem(name, manufacturer, price, category, state, quantity, pic.getAbsolutePath());
		itemRepo.save(item);
		return "added";

	}

	@RequestMapping(value = "/setQuantity", method = RequestMethod.POST)
	public String setQuantity(Model model, HttpServletRequest request, @RequestParam(value = "itemId") int id,
			@RequestParam int quantity) {

		System.out.println("The id is " + id);
		model.addAttribute("id", id);
		StockItem item = itemservice.getItem(id);
		System.out.println(item.getTitle());

		item.setQuantity(quantity);
		System.out.println(item.getTitle() + " :quantity left in stock: " + item.getQuantity());
		ArrayList<StockItem> items = new ArrayList<>();
		items = (ArrayList<StockItem>) itemservice.getAllItems();
		model.addAttribute("lists", items);
		itemRepo.save(item);
		return "viewItems";

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registration(@RequestParam String name, @RequestParam String password, @RequestParam String email,
			@RequestParam String address, @RequestParam String town, @RequestParam String county,
			@RequestParam String number, @RequestParam String payment, @RequestParam String fname,
			@RequestParam String lname, @RequestParam int date, @RequestParam int year, HttpServletRequest request) {
		User user = userservice.register(name, password, email, address);
		int type = Integer.parseInt(payment);
		Card card = new Card(fname, lname, address, town, county, number, type, date, year);
		card = cardValidator.initComponents(card);
		user.setCard(card);

		if (user == null) {

			return "login";

		} else {
			request.getSession().setAttribute("user", user);
			userRepository.save(user);
			return "success";
		}

	}

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem(HttpServletRequest request, Model model) {
		StockItem item = new StockItem();
		item.setCategory("food");
		item.setTitle("pizza");
		StockItem item2 = new StockItem();
		item2.setCategory("food");
		item2.setTitle("burger");
		items.add(item);
		items.add(item2);
		model.addAttribute("lists", this.items);
		User u = (User) request.getSession().getAttribute("user");
		User u2 = (User) session.getAttribute("user");
		System.out.println("u2 " + u2.getEmail());
		System.out.println(u.getEmail());
		Cart cart = new Cart();
		cart.getItems().add(item);
		cart.getItems().add(item2);
		u.setCart(cart);
		Order order = new Order();
		order.setCart(cart);
		u.getOrders().add(order);
		System.out.print(u.getOrders().toString());
		return "itemHome";
	}

	@RequestMapping(value = "/success")
	public String redirect(Model model) {

		return "itemhome";
	}

	@RequestMapping("/list_contact")
	public String listContact(Model model) {

		ContactBusiness business = new ContactBusiness();
		List<Contact> contactList = business.getContactList();

		model.addAttribute("contacts", contactList);

		return "contact";
	}
}
