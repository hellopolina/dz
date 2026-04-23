import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class dz3_1 {

    public static void main(String[] args) {
        String[] petyaBasket = {"Курица", "Бананы", "Творог"};
        String[] kolayBasket = {"Курица", "Бананы", "Творог"};
        String[] terentiyBasket = {"Пиво", "Пельмени", "Ласка магия черного"};

        String compareBasketItemPetyaKolya = (Arrays.equals(petyaBasket, kolayBasket)) ? "Корзины одинаковые по составу" : "Корзины разные по составу";
        String compareBasketItemPetyaTerentiy = (Arrays.equals(petyaBasket, terentiyBasket)) ? "Корзины одинаковые по составу" : "Корзины разные по составу";

        List<String> basket = new ArrayList<>();
        Collections.addAll(basket, petyaBasket);
        Collections.addAll(basket, kolayBasket);
        Collections.addAll(basket, terentiyBasket);

        String shortName = basket.get(0);
        String longName = basket.get(0);
        int averageNameSize = (shortName.length() + longName.length()) /2;

        for(String item: basket) {
            if(item.length() < shortName.length()) shortName = item;
            if(item.length() > longName.length()) longName = item;
        }

        System.out.println(
                "У кого товаров в козине больше: у Пети или Коли? " + compareBasketSize(petyaBasket, kolayBasket) + "\n" +
                        "У кого товаров в козине больше: у Пети или Терения? " + compareBasketSize(petyaBasket, kolayBasket) + "\n" +
                        "Одинаковые ли корзины по составу: у Пети и Коли? " + compareBasketItemPetyaKolya + "\n" +
                        "Одинаковые ли корзины по составу: у Пети и Терентия? " + compareBasketItemPetyaTerentiy + "\n" +
                        "Товар с самым коротким названием: " + shortName + "\n" +
                        "Товар с самым длинным названием: " + longName + "\n" +
                        "Средняя длина названия: " + averageNameSize
        );
    }

    public static String compareBasketSize(String[] basket1, String[] basket2) {
        if(basket1.length > basket2.length) {
            return "В первой корзине больше продуктов";
        }
        else if (basket1.length < basket2.length) {
            return "Во второй корзине больше продуктов";
        }
        else return "Корзины равны по размеру";
    }
}

