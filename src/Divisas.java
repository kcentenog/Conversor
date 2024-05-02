public class Divisas{

    String fechaDeConsulta;

    Double cambio;

    String base;

    String objetivo;

    double monto;

    public Divisas(CambioDivisas cambioDivisas){
        this.cambio = cambioDivisas.conversion_rate();
        this.fechaDeConsulta = cambioDivisas.time_next_update_utc();
        this.base = cambioDivisas.base_code();
        this.objetivo = cambioDivisas.target_code();
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }


    @Override
    public String toString() {
        return "El monto " + monto +
        " en " + base + " equivale a " + cambio*monto + " " + objetivo + " con fecha del " + fechaDeConsulta;
    }
}
