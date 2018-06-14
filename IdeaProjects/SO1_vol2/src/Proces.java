class Proces
{
    private int czasZycia;
    private int numer;
    private int momentZglosz;
    private int ileWyk;
    private boolean czyWyk;
    public Proces(int czasZycia, int numer, int momentZglosz)
    {
        this.czasZycia=czasZycia;
        this.numer=numer;
        this.momentZglosz=momentZglosz;
        ileWyk=0;
    }
    public void setCzas(int czas)
    {
        czas=czasZycia;
    }
    public void setNumer(int num)
    {
        num=numer;
    }
    public void setMoment(int moment)
    {
        moment=momentZglosz;
    }
    public int getCzas()
    {
        return czasZycia;
    }
    public int getNumer()
    {
        return numer;
    }
    public int getMoment()
    {
        return momentZglosz;
    }
    public void setWyk(int ileW)
    {
        ileWyk+=ileW;
    }
    public int getileWyk()
    {
        return ileWyk;
    }
    public boolean czyWyk()
    {
        if(getileWyk()>=getCzas())
        {
            return true;
        }
        return false;
    }
}