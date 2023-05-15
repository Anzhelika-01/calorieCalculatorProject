package com.tusofia.caloriecalculatorproject.web;

import com.tusofia.caloriecalculatorproject.dto.CalculatorForm;
import com.tusofia.caloriecalculatorproject.service.CalorieCalculator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class CalculatorController extends BaseController{

    private final CalorieCalculator calorieCalculator;

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";


    @Autowired
    public CalculatorController(CalorieCalculator calorieCalculator) {
        this.calorieCalculator = calorieCalculator;
    }

    @GetMapping
    public ModelAndView getCalculator() {
        return super.view("calorie-calculator");
    }

    @PostMapping("/calorie-calculator")
    public ModelAndView calculateCalories(@Valid @ModelAttribute(name = "calculatorForm") CalculatorForm calculatorForm,
                                  BindingResult result, RedirectAttributes redirectAttributes,
                                  Model model) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("calculatorForm", calculatorForm)
                    .addFlashAttribute(BINDING_RESULT_PATH + "calculatorForm", result);

            return super.view("calorie-calculator");
        }

        double caloriesPerDay = calorieCalculator.calculateCalories(calculatorForm.getSex(),
                calculatorForm.getWeight(), calculatorForm.getHeight(),
                calculatorForm.getAge(), calculatorForm.getActivityLevel());

        model.addAttribute("caloriesPerDay", caloriesPerDay);

        return super.redirect("calorie-calculator");
    }


    @ModelAttribute(name = "calculatorForm")
    public CalculatorForm getCalculatorForm() {
        return new CalculatorForm();
    }
}
