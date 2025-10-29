package utils;

import model.Plataforma;
import model.Genero;

/**
 * Class para validar datos de entrada.
 */
public class ParseUtils {

    //private ParseUtils() {} 

    public static Integer parseIntSafe(String raw) {
        try {
            if (raw == null) return null;
            return Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double parseDoubleNonNegative(String raw) {
        try {
            if (raw == null) return null;
            double v = Double.parseDouble(raw.trim().replace(',', '.'));
            return (v >= 0) ? v : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Plataforma parsePlataforma(String raw) {
        if (raw == null) return null;
        String val = raw.trim().toUpperCase();
        if (val.equals("PLAY") || val.equals("PLAYSTATION")) val = "PS";
        if (val.equals("XBOX")) val = "XB";
        if (val.equals("NINTENDO")) val = "NI";
        try {
            return Plataforma.valueOf(val);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static Genero parseGenero(String raw) {
        if (raw == null) return null;
        String val = raw.trim().toUpperCase();
        if (val.equals("ACTION")) val = "ACCION";
        if (val.equals("SPORT")) val = "SPORTS";
        try {
            return Genero.valueOf(val);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
