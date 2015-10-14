package main.i18n;

import java.util.ListResourceBundle;

public class Bundle_en_US extends ListResourceBundle {


    static final Object[][] contents = {
        { "MORE_INFO", "More Info" }, { "PRODUCT_INFORMATION", "List of goods" },
        { "CHARACTERISTICS_OF", "Characteristics of" }, { "DESCRIPTION", "Description" },
        { "REVIEWS", "Reviews" }, { "ADD_TO_CART", "Add to Cart" },{ "ADDED_TO_CART", "Added" },
        
        { "ACCEPT_FILTER", "Filter this!" },
        { "MANUFACTURER", "Manufacturer" },
        { "STYLE_TYPE", "Type" },{ "STYLE_CC", "MTB" },{ "STYLE_CITY_ROAD", "road" },{ "STYLE_CYCLO_CROSS", "cyclo" },
        { "WHEELS_SIZE", "Diameter wheels" },
        { "COST_FILTER", "Cost" },{ "COST_FILTER_MIN", "min" },{ "COST_FILTER_MAX", "max" },
        
        { "AUTH_ENTER", "Login" },{ "AUTH_LOGOUT", "Logout" },{ "AUTH_BUCKET", "Basket" },{ "AUTH_HISTORY", "History" }
            
        ,{ "BASKET", "Basket" },{ "YOUR_ITEMS", "Your items" },{ "TOTAL_AMOUNT_BASKET", "Total amount" }
        ,{ "DELETE_ALL_BASKET", "Delete all" },{ "ORDER_BASKET", "Order" },{ "BASKET_EMPTY", "There is nothing ..." }
            
        ,{ "AUTH", "Authorization" },{ "AUTH_USER", "Name : " },{ "CHOOSE_BAR_OPTION", "Choose tab" }
            
        ,{ "THANKS", "Thank you to make purchases in our store!" },{ "AUTH_LOGIN", "login" },{ "AUTH_PASS", "password" }
            ,{ "ORDER_TYPE_TITTLE", "Choose the way of purchasing goods specified place of delivery or store on the map." },
            { "ORDER_TYPE_SELECT", "Method purchase" },{ "SHOP", "Shop" },{ "CHOOSE", "Select" }
            ,{ "NEXT", "Next" },{ "SPECIFY_ADRESS", "Specify adress" },{ "BUYING_PLACE", "Place of purchase" }
            ,{ "PERSONAL_AREA", "Personal area" },{ "FEEDBACK_ABOUT", "Feedback on store" }
            ,{ "SEND", "Send" },{ "PLEASE", "Please enter in your place." }            
    };


    @Override
    protected Object[][] getContents() {
        // TODO Implement this method
        return contents;
    }
}
