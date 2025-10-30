/*package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.InMemoryJuegosData;
import model.Game;
import model.Genero;
import model.Plataforma;
import service.GameService;
import service.GameServiceImpl;

import java.util.List;

class GameControllerTest {

    private GameController controller;
    private GameService service;
    private InMemoryJuegosData data;

    @BeforeEach
    void setUp() {
        data = new InMemoryJuegosData();
        service = new GameServiceImpl(data);
        controller = new GameController(service);
    }

    @Test
    @DisplayName("Crear juego OK devuelve mensaje de éxito y se guarda en memoria")
    void createGame_ok() {
        String msg = controller.createGame(
                "1",             // ranking
                "Tetris",        // name
                "PC",            // plataforma
                "1989",          // año
                "PUZZLE",        // genero
                "Nintendo",      // editor
                "1.5", "2.0", "0.5", "0.2", "4.2"  // ventas
        );

        assertTrue(msg.startsWith("Juego creado con éxito"), "Debe devolver mensaje de éxito");

        // Comprobamos que se guardó realmente
        List<Game> all = service.listarTodos();
        assertEquals(1, all.size());
        Game g = all.get(0);
        assertEquals(1, g.getRanking());
        assertEquals("Tetris", g.getNombre());
        assertEquals(Plataforma.PC, g.getPlataforma());
        assertEquals(1989, g.getAnio());
        assertEquals(Genero.PUZZLE, g.getGenero());
        assertEquals("Nintendo", g.getEditor());
        assertEquals(1.5, g.getNA_Sales());
        assertEquals(2.0, g.getEU_Sales());
        assertEquals(0.5, g.getJP_Sales());
        assertEquals(0.2, g.getOther_Sales());
        assertEquals(4.2, g.getGlobal_sales());
    }

    @Test
    @DisplayName("Nombre vacío → error de input")
    void createGame_nombreVacio() {
        String msg = controller.createGame(
                "2", "", "PS", "2000", "ACCION", "Sony",
                "0", "0", "0", "0", "0"
        );
        assertTrue(msg.startsWith("Error"), "Debe devolver error por nombre vacío");
        assertEquals(0, service.listarTodos().size(), "No debe guardar nada");
    }

    @Test
    @DisplayName("Enum plataforma inválido → error de input")
    void createGame_plataformaInvalida() {
        String msg = controller.createGame(
                "3", "Halo", "XBOX360", "2001", "ACCION", "Microsoft",
                "1", "1", "1", "1", "4"
        );
        assertTrue(msg.startsWith("Error de input"), "Debe indicar error por enum inválido");
        assertEquals(0, service.listarTodos().size(), "No debe guardar nada");
    }

    @Test
    @DisplayName("Número inválido en ventas → error de input")
    void createGame_numeroInvalido() {
        String msg = controller.createGame(
                "4", "Zelda", "NI", "1998", "ACCION", "Nintendo",
                "uno", "2", "3", "4", "10"
        );
        assertTrue(msg.startsWith("Error de input"), "Debe indicar error por número inválido");
        assertEquals(0, service.listarTodos().size());
    }
}*/


