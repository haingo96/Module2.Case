public abstract class Word {
    protected String spell;
    protected String mean;

    public Word() {
    }

    public Word(String spell, String mean) {
        this.spell = spell;
        this.mean = mean;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    @Override
    public String toString() {
        return spell + ':' + '\'' +
                mean + '\'';
    }
}
