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
import entities.CardModel;
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

	//LOGIN
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}
	
	//ADDING
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		StockItem item = new StockItem();
		item.setTitle("First item");
		return "Saved";
	}
	
	//ALL
    @GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
    
    @RequestMapping(value = "/searchProducts", method = RequestMethod.GET)
	public String searchProducts(Model model, @RequestParam("keyword") String keyword, HttpServletRequest request, @RequestParam String style, @RequestParam String type) {
		ArrayList<StockItem> items = new ArrayList<>();
		
		System.out.println("here " + itemservice.getAllItems().size());
		SortingContext context = new SortingContext();
		for(int i=0; i<itemservice.getAllItems().size();i++) {
			//itemservice.getAllItems().get(i).getTitle().contains(keyword)
			if(type.equalsIgnoreCase("title")) {
				if(itemservice.getAllItems().get(i).getTitle().contains(keyword)) {
					items.add(itemservice.getAllItems().get(i));
				}
				context.setSortingMethod(new SortByName());
				if(style.equalsIgnoreCase("Ascending")) {
					context.ascendingSort(items);
				}else if(style.equalsIgnoreCase("Descending")){
					context.descendingSort(items);
				}
			
			
			}
		}
		for(int i=0; i<itemservice.getAllItems().size();i++) {
			//itemservice.getAllItems().get(i).getTitle().contains(keyword)
			if(type.equalsIgnoreCase("category")) {
				if( itemservice.getAllItems().get(i).getCategory().contains(keyword)) {
					items.add(itemservice.getAllItems().get(i));
				}
				context.setSortingMethod(new SortByCategory());
				if(style.equalsIgnoreCase("Ascending")) {
					context.ascendingSort(items);
				}else if(style.equalsIgnoreCase("Descending")){
					context.descendingSort(items);
				}
			
			
			}
		}
		for(int i=0; i<itemservice.getAllItems().size();i++) {
			//itemservice.getAllItems().get(i).getTitle().contains(keyword)
			if(type.equalsIgnoreCase("price")) {
				Double usedPrice = Double.parseDouble(keyword);
				if(itemservice.getAllItems().get(i).getPrice().equals(usedPrice)) {
					items.add(itemservice.getAllItems().get(i));
				}
				context.setSortingMethod(new SortByPrice());
				if(style.equalsIgnoreCase("Ascending")) {
					context.ascendingSort(items);
				}else if(style.equalsIgnoreCase("Descending")){
					context.descendingSort(items);
				}
			
			
			}
		}
		for(int i=0; i<itemservice.getAllItems().size();i++) {
			//itemservice.getAllItems().get(i).getTitle().contains(keyword)
			if(type.equalsIgnoreCase("manufacturer")) {
				if(itemservice.getAllItems().get(i).getManufacturer().equals(keyword) ) {
					items.add(itemservice.getAllItems().get(i));
				}
				context.setSortingMethod(new SortByManufacturer());
				if(style.equalsIgnoreCase("Ascending")) {
					context.ascendingSort(items);
				}
				else if(style.equalsIgnoreCase("Descending")){
					context.descendingSort(items);
				}
			
			
			}
		}
		System.out.println(items.size());
		
		
		
		model.addAttribute("lists",items);
		String userName = (String) request.getSession().getAttribute("admin");
		if(userName !=null) {
		if(userName.equalsIgnoreCase("Admin")) {
			return "viewItems";
		}
		}
		return "cart";
	}
    
    @RequestMapping(value= "/allCustomers" , method = RequestMethod.POST)
    public String customerDetails(HttpServletRequest request,Model model) {
    	final ArrayList<User>customersArrayList;
    	customersArrayList = (ArrayList<User>)userservice.getAllUsers();
    	UserList custsList = new UserList(customersArrayList);
    	ArrayList<User>listAll = new ArrayList<User>();
    	for(Iterator iterator = custsList.getIterator();iterator.hasNext();) {
    		User name = (User) iterator.next();
    		//int id = name.getId();
    		//String fname= name.getfName();
    		String userName = name.getName();
    		String email = name.getEmail();
    		//String lname = name.getlName();
    		String password = name.getPassword();
    		String address = name.getAddress();
    		User user1 = new User(userName,email,password,address);
    		listAll.add(user1);
    		
    	}
    	for(int i=0; i <listAll.size();i++) {
    		System.out.println(listAll.get(i).getEmail());
    	}
    	model.addAttribute("allUsers", listAll);
    	System.out.println(listAll.size());
    	request.getSession().setAttribute("allUsers", listAll);
		return "customerDetails";
    }
	
	
	
	
	
	
	
	
	
	@RequestMapping("/list_contact")
	public String listContact(Model model) {

		ContactBusiness business = new ContactBusiness();
		List<Contact> contactList = business.getContactList();

		model.addAttribute("contacts", contactList);

		return "contact";
	}
}
