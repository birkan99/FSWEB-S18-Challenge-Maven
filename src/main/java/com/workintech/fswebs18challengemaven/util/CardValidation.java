package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {

    public static void validateCard(Card card) {
        if (card == null) {
            throw new CardException("Card object cannot be null", HttpStatus.BAD_REQUEST);
        }

        if (card.getType() != null && card.getValue() != null) {
            throw new CardException("A card cannot have both a type and a value", HttpStatus.BAD_REQUEST);
        }

        if (card.getType() == null && card.getValue() == null) {
            throw new CardException("A card must have either a type or a value", HttpStatus.BAD_REQUEST);
        }

        if (Type.JOKER.equals(card.getType())) {
            if (card.getValue() != null || card.getColor() != null) {
                throw new CardException("JOKER card must have null value and null color", HttpStatus.BAD_REQUEST);
            }
        }
    }

    public static String checkColor(String color) {
        try {
            return color.toUpperCase();
        } catch (Exception e) {
            throw new CardException("Invalid color value", HttpStatus.BAD_REQUEST);
        }
    }

    public static String checkType(String type) {
        try {
            return type.toUpperCase();
        } catch (Exception e) {
            throw new CardException("Invalid type value", HttpStatus.BAD_REQUEST);
        }
    }
}