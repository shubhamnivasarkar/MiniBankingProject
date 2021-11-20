package com.app.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.BankAccount;
import com.app.service.IBankAccountService;

@Controller
@RequestMapping("/bankAccount")
public class BankAccountController {
	@Autowired
	private IBankAccountService bankAccountService;

	public BankAccountController() {
		System.out.println("in bankAccountController " + getClass().getName());
	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/bankAccount/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map, HttpSession hs,
			RedirectAttributes flashMap) {
		System.out.println("in process login form");
		try {
			BankAccount acctholder = bankAccountService.authenticateBankAccount(email, password);
			hs.setAttribute("BankAccount_details", Arrays.asList(acctholder));
			flashMap.addFlashAttribute("message", acctholder.getName() + " " + "logged in!!!!");
			return "redirect:/bankAccount/details";
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("in erro catch of processLoginForm " + e);
			map.addAttribute("message", "Invalid login");
			return "/bankAccount/login";
		}

	}

	@GetMapping("/logout")
	public String BankAccountLogout(HttpSession session, Model map, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("in BankAccountLogout");
		map.addAttribute("BankAccount_details", session.getAttribute(""));
		
		session.invalidate();
		// set HTTP resopnse header : name = refresh
		// value = 5 : url = request.getContextPath()---/spring mvc
		response.setHeader("refresh", "5;url= " + request.getContextPath());
		return "/bankAccount/logout";
	}

	@GetMapping("/details")
	public String showAccountDetails() {
		System.out.println("in show account details");
		return "/bankAccount/details";

	}

	@GetMapping("/delete")
	public String processDeleteAccount(@RequestParam int aid, RedirectAttributes flashMap) {
		System.out.println("in process delete account " + aid + " " + flashMap);
		flashMap.addAttribute("message", bankAccountService.deleteBankAccountHolderDetails(aid));
		return "/bankAccount/login";
	}

	@GetMapping("/register")
	public String showRegisterAccountForm(BankAccount acct) {
		System.out.println("in show register account form" + acct);
		return "/bankAccount/register";
	}

	@PostMapping("/register")
	public String processRegisterAccoutForm(BankAccount acct, RedirectAttributes flashMap) {
		System.out.println("in process register account form ");
		flashMap.addAttribute("message", bankAccountService.registerNewAccount(acct));
		return "redirect:/bankAccount/login";
	}

	@GetMapping("/newaccount")
	public String newBankAccount(BankAccount acct) {
		System.out.println("in new bank account" + acct);
		return "/bankAccount/newaccount";
	}

	@PostMapping("/newaccount")
	public String processNewBanKAccount(BankAccount acct, RedirectAttributes flashMap) {
		System.out.println("in process new register account " + acct);
		flashMap.addAttribute("message", bankAccountService.registerNewAccount(acct));
		return "redirect:/bankAccount/login";
	}

	@GetMapping("/withdrawl")
	public String withdrawBalance(@RequestParam int aid, @RequestParam double balance, Model map,
			RedirectAttributes flashMap) {
		System.out.println("in withdrawl balance controller" + balance + " " + aid + " " + flashMap);
		flashMap.addAttribute("message", bankAccountService.withdrawlBalance(aid, balance));
		return "redirect:/bankAccount/login";
	}

	@GetMapping("/deposit")
	public String depositBalance(@RequestParam int aid, @RequestParam double balance, Model map,
			RedirectAttributes flashMap) {
		System.out.println("in deposit balance controller " + balance + " " + aid + " " + flashMap);
		flashMap.addAttribute("message", bankAccountService.depositBalance(aid, balance));
		return "redirect:/bankAccount/login";
	}

}
