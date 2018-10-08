package com.datastructure.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cards {

    //一副扑克牌，随机抽取5张，判断是否为葫芦（3个一样的+1对，如222jj），a为1，J为11，Q为12，K为13，王可以代替任何数字
    private static final String KING = "king";
    private static final String[] ALLCARDS =new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public static void main(String[] args) {
        System.out.println(isHuLu(new String[]{"A", "A", "A", "J", "J"}));
        System.out.println(isHuLu(new String[]{"2", "3", "2", "J", "J"}));
        System.out.println(isHuLu(new String[]{"2", "J", "2", "2", "J"}));
        System.out.println(isHuLu(new String[]{"2", "P", "2", "p", "J"}));
        System.out.println(isHuLu(new String[]{"10", "10", "P", "10", "A"}));
        System.out.println(isHuLu(new String[]{"2", "2", "P", "p", "J"}));
        System.out.println(isHuLu(new String[]{"2", "2", "P", "p"}));
    }

    private static boolean isHuLu(String cards[]){

        if (cards.length != 5){
            return false;
        }

        String[] tempCards = new String[5];
        for (int i=0; i < cards.length; i++){
            if (isKing(cards[i])){
                tempCards[i] = KING;
            }else {
                tempCards[i] = cards[i];
            }
        }

        Map<String, Integer> cardMap = new HashMap<String, Integer>();
        for (String card:tempCards){
            if (cardMap.get(card) == null  ){
                cardMap.put(card, 1);
            }else {
                cardMap.put(card, cardMap.get(card)+1);
            }
        }

        int cardKinds = cardMap.size();//牌的种类

        if (cardKinds >= 4 || cardKinds <2 ){
            return false;
        }else if (cardKinds == 2){
            if (cardMap.get(tempCards[0]) <= 1  || cardMap.get(tempCards[0]) >= 4){
                return false;
            }else {
                return true;
            }
        }else {
            if (cardMap.get(KING) != null){
                return true;
            }else {
                return false;
            }
        }

    }

    private static boolean isKing(String card){
        return !Arrays.asList(ALLCARDS).contains(card);
    }

}
