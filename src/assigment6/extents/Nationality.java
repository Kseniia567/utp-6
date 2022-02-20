package assigment6.extents;

import java.text.Collator;
import java.util.Locale;
import java.util.Random;

public enum Nationality {
    POLISH(new Locale("pl")),
    UKRAINIAN(new Locale("uk")),
    BELARUSIAN(new Locale("be")),
    SLOVAK(new Locale("sk")),
    LITHUANIAN(new Locale("lt")),
    LATVIAN(new Locale("lv")),
    BRITISH(new Locale("en_UK")),
    INDIAN(new Locale("hi")),
    CHINESE(new Locale("zh")),
    VIETNAMESE(new Locale("vi"));



    private final static Random random = new Random();
    private final Locale _lang;
    private final Collator _collator;


Nationality(Locale lang) {
    _lang = lang;
    _collator = Collator.getInstance(_lang);
}


    public Collator get_collator() {
        return _collator;
    }


    public Locale get_lang() {
        return _lang;
    }

    public static Nationality randomNationality() {
    var nationalities = Nationality.values();
    var index = random.nextInt(nationalities.length);
    return nationalities[index];
}


}
