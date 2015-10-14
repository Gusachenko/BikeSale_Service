package main.i18n;

import java.util.ListResourceBundle;

public class Bundle_ru_RU extends ListResourceBundle {
    static final Object[][] contents = {
        { "MORE_INFO", "О товаре" }, { "PRODUCT_INFORMATION", "Список товаров" },
        { "CHARACTERISTICS_OF", "Характеристики" }, { "DESCRIPTION", "Описание" },
        { "REVIEWS", "Отзывы" }, { "ADD_TO_CART", "Добавить в корзину" },{ "ADDED_TO_CART", "Добавленно" },
        
        { "ACCEPT_FILTER", "Отфильтровать это!" },
        { "MANUFACTURER", "Производитель" },
        { "STYLE_TYPE", "Тип" },{ "STYLE_CC", "горный(MTB)" },{ "STYLE_CITY_ROAD", "дорожный" },{ "STYLE_CYCLO_CROSS", "шоссейный" },
        { "WHEELS_SIZE", "Диаметр колёс" },
        { "COST_FILTER", "Цена" },{ "COST_FILTER_MIN", "от" },{ "COST_FILTER_MAX", "до" },
        
        { "AUTH_ENTER", "Войти" },{ "AUTH_LOGOUT", "Выход" },{ "AUTH_BUCKET", "Корзина" },{ "AUTH_HISTORY", "История" }
            
        ,{ "BASKET", "Корзина" },{ "YOUR_ITEMS", "Ваши предметы" },{ "TOTAL_AMOUNT_BASKET", "Общая сумма" }
        ,{ "DELETE_ALL_BASKET", "Удалить всё" },{ "ORDER_BASKET", "Заказ" },{ "BASKET_EMPTY", "Здесь пока ничего нет ..." }
            
            
        ,{ "AUTH", "Авторизация" },{ "AUTH_USER", "Ник : " },{ "CHOOSE_BAR_OPTION", "Выбор закладки" }
            
            ,{ "THANKS", "Спасибо что сделали покупку в нашем магазине!" },{ "AUTH_LOGIN", "логин" },{ "AUTH_PASS", "пароль" }
            ,{ "ORDER_TYPE_TITTLE", "Выберите способ покупки товара, указав место доставки либо магазин на карте." },
            { "ORDER_TYPE_SELECT", "Способ покупки" },{ "SHOP", "Магазин" },{ "CHOOSE", "Выбор" }
            ,{ "NEXT", "Далее" },{ "SPECIFY_ADRESS", "Указать адрес" },{ "BUYING_PLACE", "Место покупки" }
            ,{ "PERSONAL_AREA", "Личный кабинет" },{ "FEEDBACK_ABOUT", "Отзыв о магазине" }
            ,{ "SEND", "Отправить" },{ "PLEASE", "Пожалуйста Авторизируйтесь" }
    };
    @Override
    protected Object[][] getContents() {
        // TODO Implement this method
        return contents;
    }
}
