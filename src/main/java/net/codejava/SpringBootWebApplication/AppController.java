package net.codejava.SpringBootWebApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Validation.CardValidator;
import entities.CardModel;
import models.CartModel;
import models.CommentModel;
import models.OrderModel;
import models.StockItemModel;
import services.ItemService;
import services.OrderService;
import services.UserService;

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
	
	@Autowired
	CardValidator cardValidator = new CardValidator();
    @RequestMapping("/list_contact")
    public String listContact(Model model) {
         
        ContactBusiness business = new ContactBusiness();
        List<Contact> contactList = business.getContactList();
         
        model.addAttribute("contacts", contactList);       
         
        return "contact";
    }
}
