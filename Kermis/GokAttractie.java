package eu.additude.zarchief.Kermis;

interface GokAttractie  {
    void berekenNetto();
    default int berekenReservering(int bruto) {
        return ((bruto * 3) / 10);
    }
}
