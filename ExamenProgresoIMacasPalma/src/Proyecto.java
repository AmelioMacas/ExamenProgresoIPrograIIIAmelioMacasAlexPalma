
public class Proyecto implements Comparable<Proyecto> {

    private int codigo;
    private String nombre;
    private String tipo;          // Tecnológico, Social o Ambiental
    private float costoEstimado;
    private int prioridad;        // 1 a 10

    public Proyecto() {
        this.codigo = 0;
        this.nombre = "Sin nombre";
        this.tipo = "Tecnológico";
        this.costoEstimado = 0.0f;
        this.prioridad = 1;
    }

    public Proyecto(int codigo, String nombre, String tipo, float costoEstimado, int prioridad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.costoEstimado = costoEstimado;
        this.prioridad = prioridad;
    }

    public double calcularCostoAjustado() {
        switch (tipo) {
            case "Tecnológico":
                return costoEstimado * 1.15;   // +15%
            case "Social":
                return costoEstimado * 0.90;   // -10%
            case "Ambiental":
                return costoEstimado * 0.95;   // -5%
            default:
                return costoEstimado;
        }
    }

    @Override
    public int compareTo(Proyecto otro) {
        int resultado = Integer.compare(otro.prioridad, this.prioridad);
        if (resultado == 0) {
            resultado = Integer.compare(this.codigo, otro.codigo);
        }
        return resultado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(float costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "----------------Código: " + codigo + "-----------------" +
                "\n  Nombre: " + nombre +
                "\n  Tipo: " + tipo +
                "\n  Costo estimado: " + String.format("%.2f", costoEstimado) +
                "\n  Prioridad: " + prioridad;
    }
}
