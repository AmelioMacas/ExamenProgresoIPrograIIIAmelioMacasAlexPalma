import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ColaProyectos {

    private PriorityQueue<Proyecto> colaProyectos;

    public ColaProyectos() {
        colaProyectos = new PriorityQueue<>();
        cargarPredefinidos();
    }

    private void cargarPredefinidos() {
        colaProyectos.add(new Proyecto(101, "Plataforma de telemedicina", "Tecnológico", 25000.00f, 9));
        colaProyectos.add(new Proyecto(102, "Comedor comunitario", "Social", 8000.00f, 7));
        colaProyectos.add(new Proyecto(103, "Sistema de inventario", "Tecnológico", 15000.00f, 5));
        colaProyectos.add(new Proyecto(104, "Alfabetización de adultos", "Social", 6000.00f, 3));
        colaProyectos.add(new Proyecto(105, "Red de sensores IoT", "Tecnológico", 12000.00f, 10));
    }

    public boolean existeCodigo(int codigo) {
        for (Proyecto p : colaProyectos) {
            if (p.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean agregar(Proyecto proyecto) {
        if (proyecto == null || existeCodigo(proyecto.getCodigo())) {
            return false;
        }
        colaProyectos.add(proyecto);
        return true;
    }

    public List<Proyecto> listarOrdenado() {
        List<Proyecto> lista = new ArrayList<>(colaProyectos);
        Collections.sort(lista);
        return lista;
    }

    public String mostrarProyectos() {
        List<Proyecto> lista = new ArrayList<>(colaProyectos);
        Collections.sort(lista);

        StringBuilder sb = new StringBuilder();
        sb.append("PROYECTOS ORDENADOS DE MAYOR A MENOR PRIORIDAD\n\n");
        for (Proyecto p : lista) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }

    public String mostrarCostosAjustados() {
        List<Proyecto> lista = new ArrayList<>(colaProyectos);
        Collections.sort(lista);

        StringBuilder sb = new StringBuilder();
        sb.append("PROYECTOS CON COSTO AJUSTADO\n");
        sb.append("(Tecnológico +15% | Social -10% | Ambiental -5%)\n\n");
        for (Proyecto p : lista) {
            sb.append(p)
                    .append(" | Costo ajustado: ")
                    .append(String.format("%.2f", p.calcularCostoAjustado()))
                    .append("\n");
        }
        return sb.toString();
    }

    public double totalEstimadoPorTipo(String tipo) {
        double total = 0;
        for (Proyecto p : colaProyectos) {
            if (p.getTipo().equals(tipo)) {
                total += p.getCostoEstimado();
            }
        }
        return total;
    }

    public double totalAjustadoPorTipo(String tipo) {
        double total = 0;
        for (Proyecto p : colaProyectos) {
            if (p.getTipo().equals(tipo)) {
                total += p.calcularCostoAjustado();
            }
        }
        return total;
    }

    public PriorityQueue<Proyecto> getColaProyectos() {
        return colaProyectos;
    }
}
