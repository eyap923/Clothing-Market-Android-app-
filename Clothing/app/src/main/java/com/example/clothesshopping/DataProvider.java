package com.example.clothesshopping;


import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DataProvider {

    //Data for bottoms
    public static Object[] generateBottoms() {
        ArrayList BottomNames = new ArrayList<String>();
        ArrayList BottomPrices = new ArrayList<String>();
        ArrayList BottomOrders = new ArrayList<Integer>();
        ArrayList BottomDesc = new ArrayList<String>();
        BottomNames.add("5XL High Waist Jeans");
        BottomPrices.add("15.99");
        BottomOrders.add(23);
        BottomDesc.add("Dark blue jeans with a stretchy waist that go up to size 5XL. Perfect for any season!");
        BottomNames.add("Summer Floral Print Pants");
        BottomPrices.add("16.99");
        BottomOrders.add(34);
        BottomDesc.add("Are you a summery person? Then these pants are for you! With a cute wakcy pattern, these pants are great with a nice plain white shirt");
        BottomNames.add("CamkKemsey Japanese Harauku Casual Pants");
        BottomPrices.add("20.99");
        BottomOrders.add(90);
        BottomDesc.add("Japanese style with a high tieable waist for maximum comfort");
        BottomNames.add("Hip Hop High Waist Pants");
        BottomPrices.add("11.99");
        BottomOrders.add(35);
        BottomDesc.add("you are not a true hip hop fan if you don't have these pants. They are black pants with pockets for everyday use");
        BottomNames.add("Embroidery Denim Pants");
        BottomPrices.add("12.99");
        BottomOrders.add(110);
        BottomDesc.add("a lovely cute pastel purple colour with a cute cartoon feature on the ankles");
        BottomNames.add("High Waist Leisure");
        BottomPrices.add("13.99");
        BottomOrders.add(167);
        BottomDesc.add("comfortable yet stylish white pants suitable for a qide range of activities. Great paired with high top sneakers");
        BottomNames.add("Jierlur Shorts");
        BottomPrices.add("19.99");
        BottomOrders.add(123);
        BottomDesc.add("White Shorts that come with a D buckle belt making them that little bit more stylish");
        BottomNames.add("Vintage Leopard Print");
        BottomPrices.add("13.99");
        BottomOrders.add(33);
        BottomDesc.add("This vintage skirt is perfect for any season, and will make you look elegant for any occasion.");
        BottomNames.add("Black Elastic Waist Skirt");
        BottomPrices.add("15.99");
        BottomOrders.add(234);
        BottomDesc.add("A lovely girly stretchy black skirt, suitable for going out or as a casual skirt. Pair with black boots for ultimate style!");
        BottomNames.add("Tangada Black Suit Pants");
        BottomPrices.add("30.99");
        BottomOrders.add(45);
        BottomDesc.add("Struggling to pick out your work pants? Struggle no more! These lovely suit pants come with a belt for eas of fit, and will suit well with any work blouse");

        return new Object[]{BottomNames, BottomPrices, BottomOrders, BottomDesc};
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<ClothingItem> getBottoms() {
        ArrayList BottomList = new ArrayList<ClothingItem>();
        ArrayList BottomsName;
        ArrayList BottomsPrice;
        ArrayList BottomsOrders;
        ArrayList BottomsDesc;
        Object[] Bottoms = generateBottoms();
        BottomsName = (ArrayList) Bottoms[0];
        BottomsPrice = (ArrayList) Bottoms[1];
        BottomsOrders = (ArrayList) Bottoms[2];
        BottomsDesc = (ArrayList) Bottoms[3];
        int index = 0;
        for (int i = 1; i < 30; i=i+3)
        {
            String[] images = new String[]{"bottom_" + String.valueOf(i+2), "bottom_" + String.valueOf(i+1), "bottom_" + String.valueOf(i)};
            String name = "\uD83D\uDC56" + (String) BottomsName.get(index);
            String price = "\uD83D\uDCB8" + "$" +(String) BottomsPrice.get(index);
            Integer orders = (Integer) BottomsOrders.get(index);
            String desc = (String) BottomsDesc.get(index);
            ClothingItem c =new ClothingItem(images, name, price, orders, desc);
            BottomList.add(c);
            index++;
        }

        BottomList.sort(Comparator.comparing(ClothingItem::getOrders));
        Collections.reverse(BottomList);
        return BottomList;
    }

    //Data for tops
    public static Object[] generateTops() {
        ArrayList TopNames = new ArrayList<String>();
        ArrayList TopPrices = new ArrayList<String>();
        ArrayList TopOrders = new ArrayList<Integer>();
        ArrayList TopDesc = new ArrayList<String>();
        TopNames.add("Deep V Neck Sweater");
        TopPrices.add("20.99");
        TopOrders.add(55);
        TopDesc.add("Lovely elegant sweater that pairs well with a dainty necklace. Has a stretchy waist so is able to fit many sizes");
        TopNames.add("Black Blouse");
        TopPrices.add("21.99");
        TopOrders.add(234);
        TopDesc.add("Black blouse with a see-through detail on the shoulders increasing the elegance of the piece");
        TopNames.add("White Pink Long Sleeve Turtleneck Sweater");
        TopPrices.add("22.99");
        TopOrders.add(23);
        TopDesc.add("A two toned turtleneck for ultimate warmth and style during fall and spring. Perfect with a coffee!");
        TopNames.add("Dingaozlz Ruffles Lace Blouse");
        TopPrices.add("25.99");
        TopOrders.add(34);
        TopDesc.add("Beautiful Lace Blouse. A lightweight material perfect for summer. Great for casual and formal wear");
        TopNames.add("Elegant Embroidery Long Sleeve");
        TopPrices.add("18.99");
        TopOrders.add(189);
        TopDesc.add("Lovely long sleeve embroided shirt to spice up the usual plain white shirt. Great tucked in to a skirt or jeans");
        TopNames.add("Korean Fashion - Short Sleeve Pink Lacey Blouse");
        TopPrices.add("40.99");
        TopOrders.add(347);
        TopDesc.add("A cute short sleeve pink lacey blouse for added detail to increase the elegance of any outfit.");
        TopNames.add("Casual Office Shirt");
        TopPrices.add("30.99");
        TopOrders.add(78);
        TopDesc.add("A cute casual office shirt that is great for any fancy skirt or pants for work");
        TopNames.add("Autumn Fashion Off Shoulder Lace Top");
        TopPrices.add("35.99");
        TopOrders.add(99);
        TopDesc.add("Lovely elegant off the shoulder lace top, great to increase the elegance of any outfit");
        TopNames.add("Autumn Winter Korwan Kawaii Cute Lace");
        TopPrices.add("12.99");
        TopOrders.add(87);
        TopDesc.add("Cute sweater with lace details on the collar and sleeves");
        TopNames.add("V Neck, Short-Sleeve, Knitted Slim Top");
        TopPrices.add("11.99");
        TopOrders.add(123);
        TopDesc.add("Cute rainbow v neck knitted top with button details. Lovely with a pair of blue jeans");

        return new Object[]{TopNames, TopPrices, TopOrders, TopDesc};
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<ClothingItem> getTops() {
        ArrayList TopList = new ArrayList<ClothingItem>();
        ArrayList TopNames;
        ArrayList TopPrices;
        ArrayList TopOrders;
        ArrayList TopDesc;
        Object[] Tops = generateTops();
        TopNames = (ArrayList) Tops[0];
        TopPrices = (ArrayList) Tops[1];
        TopOrders= (ArrayList) Tops[2];
        TopDesc = (ArrayList) Tops[3];

        int index = 0;
        for (int i = 1; i < 30; i=i+3)
        {
            String[] images = new String[]{"top_" + String.valueOf(i+2), "top_" + String.valueOf(i+1), "top_" + String.valueOf(i)};
            String name = 	"\uD83D\uDC5A" + (String) TopNames.get(index);
            String price = "\uD83D\uDCB8" +"$" + (String) TopPrices.get(index);
            Integer orders = (Integer) TopOrders.get(index);
            String desc = (String) TopDesc.get(index);
            ClothingItem c =new ClothingItem(images, name, price, orders, desc);
            TopList.add(c);
            index++;
        }
        TopList.sort(Comparator.comparing(ClothingItem::getOrders));
        Collections.reverse(TopList);
        return TopList;
    }

    //Data for dresses
    public static Object[] generateDresses() {
        ArrayList DressNames = new ArrayList<String>();
        ArrayList DressPrices = new ArrayList<String>();
        ArrayList DressOrders = new ArrayList<Integer>();
        ArrayList DressDesc = new ArrayList<String>();
        DressNames.add("Summer Shirt Style Black Dress");
        DressPrices.add("18.99");
        DressOrders.add(24);
        DressDesc.add("Cute black dress with a cut out shoulder detail, buttons and a buckle belt giving the dress a cute casual style");
        DressNames.add("Floral Print Vintage Dress");
        DressPrices.add("19.99");
        DressOrders.add(11);
        DressDesc.add("Lovely ruffled vintage dress with floral details great for spring");
        DressNames.add("Mini Casual Shirt Dress");
        DressPrices.add("10.99");
        DressOrders.add(45);
        DressDesc.add("A casual but stylish long sleeve shirt dress with a waist gathering detail");
        DressNames.add("Sweet Lace White Dress");
        DressPrices.add("11.99");
        DressOrders.add(124);
        DressDesc.add("An off the shoulder lace dress perfect for a casual summer look");
        DressNames.add("Off Shoulder High Waist V neck Casual Dress");
        DressPrices.add("18.99");
        DressOrders.add(99);
        DressDesc.add("A cute v neck summer dress with a lovely mustard colouring. A great trendy and girly look");
        DressNames.add("White Mini Chiffon Dress");
        DressPrices.add("25.99");
        DressOrders.add(242);
        DressDesc.add("Lovely chiffon dress made of a light material suitable for summer.");
        DressNames.add("Summer Beach Polka Dot Dress");
        DressPrices.add("30.99");
        DressOrders.add(53);
        DressDesc.add("Cute polka dot dress with a belt to accentuate the waist.");
        DressNames.add("Summer Beach Casual Slim Dress");
        DressPrices.add("25.99");
        DressOrders.add(23);
        DressDesc.add("Cute slim casual dress with polkadot details with a high neckline");
        DressNames.add("Korean Autumn Floral Long Sleeve Print Dress");
        DressPrices.add("22.99");
        DressOrders.add(124);
        DressDesc.add("Cute floral long sleeve dress with a cute tie up collar and waist details. The floral details make the dress perfect for autumn and spring");
        DressNames.add("Off Shoulder Floral Print Chiffon Dress");
        DressPrices.add("23.99");
        DressOrders.add(653);
        DressDesc.add("Cute off the shoulder dress with larger flower features and an H line shape");

        return new Object[]{DressNames, DressPrices, DressOrders, DressDesc};
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<ClothingItem> getDresses() {
        ArrayList DressList = new ArrayList<ClothingItem>();
        ArrayList DressNames;
        ArrayList DressPrices;
        ArrayList DressOrders;
        ArrayList DressDesc;
        Object[] Dress = generateDresses();
        DressNames = (ArrayList) Dress[0];
        DressPrices = (ArrayList) Dress[1];
        DressOrders = (ArrayList) Dress[2];
        DressDesc = (ArrayList) Dress[3];
        int index = 0;
        for (int i = 1; i < 30; i=i+3)
        {
            String[] images = new String[]{"dress_" + String.valueOf(i+2), "dress_" + String.valueOf(i+1), "dress_" + String.valueOf(i)};
            String name = "\uD83D\uDC57" + (String) DressNames.get(index);
            String price = "\uD83D\uDCB8" +"$" + (String) DressPrices.get(index);
            Integer orders = (Integer) DressOrders.get(index);
            String desc = (String) DressDesc.get(index);
            ClothingItem c =new ClothingItem(images, name, price, orders, desc);
            DressList.add(c);
            index++;
        }

        DressList.sort(Comparator.comparing(ClothingItem::getOrders));
        Collections.reverse(DressList);
        return DressList;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<ClothingItem> getAll() {
        ArrayList fullList = new ArrayList<ClothingItem>();
        fullList.addAll(getTops());
        fullList.addAll(getDresses());
        fullList.addAll(getBottoms());
        fullList.sort(Comparator.comparing(ClothingItem::getOrders));
        Collections.reverse(fullList);
        return fullList;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<ClothingItem> getTopPicks() {
        ArrayList fullList = new ArrayList<ClothingItem>();
        ArrayList topPicks = new ArrayList<ClothingItem>();
        fullList = getAll();
        Collections.sort(fullList, ClothingItem.OrderComparator);
        topPicks.add(fullList.get(0));
        topPicks.add(fullList.get(1));
        topPicks.add(fullList.get(2));
        return topPicks;
    }


}
