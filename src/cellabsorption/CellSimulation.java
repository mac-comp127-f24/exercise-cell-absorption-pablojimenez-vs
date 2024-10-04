package cellabsorption;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("SameParameterValue")
public class CellSimulation {
    private Random rand = new Random();
    private Cell cell;
    // private ArrayList<Cell> cells = new ArrayList<Cell>();
    // cells = new ArrayList<>();
    private Ellipse shape;    // check
    private ArrayList<Cell> cellList;

    private CanvasWindow canvas;

    public static void main(String[] args) {
        new CellSimulation();
    }

    public void populateCells() {
        
        cellList = new ArrayList<Cell>();
        while (cellList.size() != 200){
        double size = rand.nextInt(5) + 2;
        cellList.add(new Cell(rand.nextDouble() * (canvas.getWidth() - size), rand.nextDouble() * (canvas.getWidth() - size),size,Color.getHSBColor(rand.nextFloat(), rand.nextFloat() * 0.5f + 0.1f, 1)));
        canvas.add(cellList.get(cellList.size() - 1).getShape());
        // canvas.add(cellList);
        }
        while(true) {
        for (Cell cell : cellList) {
            Point canvasCenter = new Point(canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
            cell.moveAround(canvasCenter);
            handleCellInteraction();

            canvas.draw();
            // canvas.pause(10);
        }
        
    }
        
    }

    private void handleCellInteraction() {
        for (int i = 0; i < cellList.size(); i++) {
            Cell cell0 = cellList.get(i);
            for (int j = i + 1; j < cellList.size(); j++) {
                Cell cell1 = cellList.get(j);
                // TODO: insert call here to make cell0 interact with cell1
                cell1.interactWith(cell0);
            }
        }
    }


    public CellSimulation() {
        canvas = new CanvasWindow("Cell Absorption", 800, 800);
        populateCells();

        //noinspection InfiniteLoopStatement
    }

    private static double sqr(double x) {
        return x * x;
    }

}
