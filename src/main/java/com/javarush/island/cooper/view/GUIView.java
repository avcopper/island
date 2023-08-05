package com.javarush.island.cooper.view;

import java.awt.*;
import javax.swing.*;
import java.util.Map;
import com.javarush.island.cooper.entity.Cell;
import com.javarush.island.cooper.entity.Unit;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.app.Application;
import com.javarush.island.cooper.system.Settings;
import com.javarush.island.cooper.entity.Coordinates;
import com.javarush.island.cooper.exception.AppException;
import com.javarush.island.cooper.constants.AppConstants;
import com.javarush.island.cooper.constants.AnimalConstants;

public class GUIView extends JFrame implements View {
    Island island; // остров
    Settings settings; // настройки

    private final int width; // ширина окна
    private final int height;// высота окна

    private final JTextArea[][] tiles; // массив ячеек
    private final Cell[][] cells; // массив клеток

    private JPanel jPanel;

    public GUIView(Island island, Settings settings) {
        super(AppConstants.APP_NAME);

        this.island = island;
        this.settings = settings;

        width = settings.getWindowWidth();
        height = settings.getWindowHeight();

        tiles = island.getTiles();
        cells = island.getCells();
    }

    /**
     * Рисует окно программы
     */
    public void start() {
        try {
            initWindow();
            initPanel();
            initTiles();
            setVisible(true);
            if (checkSettings()) {
                initUnits();
                //new ShowMap(island, settings).run();
            }

            Application.startSimulation(island, settings);
        } catch (AppException e) {
            showError(e.getMessage());
        }
    }

    /**
     * Инициализирует окно
     */
    private void initWindow() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((size.width / 2) - (width / 2), (size.height / 2) - (height / 2), width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Инициализирует панель
     */
    private void initPanel() {
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(settings.getRowsCount(), settings.getColsCount(),2,2));
        jPanel.setBounds(0, 0, width, height);
        jPanel.setBackground(Color.GRAY);
        add(jPanel);
    }

    /**
     * Инициализирует плитки графического интерфейса
     */
    private void initTiles() {
        for (int y = 0; y < settings.getRowsCount(); y++) {
            for (int x = 0; x < settings.getColsCount(); x++) {
                cells[y][x] = new Cell(new Coordinates(x, y));
                tiles[y][x] = new JTextArea(AppConstants.EMPTY_STRING);
                tiles[y][x].setEditable(false);
                tiles[y][x].setLineWrap(true);
                tiles[y][x].setWrapStyleWord(true);
                tiles[y][x].setFont(new Font(Font.SERIF, Font.PLAIN, getFontSize()));
                jPanel.add(tiles[y][x]);
            }
        }
    }

    /**
     * Проверяет настройки
     * @return
     */
    private boolean checkSettings() {
        for (Map.Entry<String, Integer> item : settings.getAnimalStartCount().entrySet()) {
            String unitName = item.getKey();
            Integer unitCount = item.getValue();
            Integer maxCount = AnimalConstants.ANIMAL_MAX_COUNT.get(unitName) * settings.getColsCount() * settings.getRowsCount();

            if (unitCount > maxCount)
                throw new AppException(String.format(AppConstants.TOO_MUCH_ANIMALS, unitName, unitCount, maxCount));
        }

        return true;
    }

    /**
     * Инициализирует существ на острове
     */
    private void initUnits() {
        try {
            for (Map.Entry<String, Integer> item : settings.getAnimalStartCount().entrySet()) {
                Coordinates coordinates;
                Cell cell;
                String unitName = item.getKey();

                for (int i = 0; i < item.getValue(); i++) {
                    Unit newUnit = Unit.create(unitName);

                    do {
                        coordinates = Coordinates.generateCoordinates(settings.getColsCount(), settings.getRowsCount());
                        cell = cells[coordinates.getY()][coordinates.getX()];
                    } while (!cell.canPutUnit(unitName));

                    cell.addUnit(newUnit);
                }
            }
        } catch (SecurityException | IllegalArgumentException e) {
            throw new AppException(e);
        }
    }

    /**
     * Возвращает размер шрифта
     * @return
     */
    private int getFontSize() {
        return switch (settings.getColsCount()) {
            case 0, 1, 2, 3, 4, 5 -> 16;
            case 6, 7, 8, 9, 10 -> 14;
            case 11, 12, 13, 14, 15 -> 12;
            case 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 -> 10;
            case 31, 32, 33, 34, 35 -> 9;
            case 36, 37, 38, 39, 40 -> 8;
            case 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 -> 7;
            case 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 -> 6;
            case 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 -> 5;
            case 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120 -> 4;
            default -> 3;
        };

    }

    /**
     * Показывает ошибки в графической оболочке
     * @param message - текст ошибки
     */
    private void showError(String message) {
        UIManager.put(AppConstants.OPTIONPANE_MINIMUM_SIZE, new Dimension(AppConstants.PANE_WIDTH, AppConstants.PANE_HEIGHT));
        JOptionPane.showMessageDialog(this, message, AppConstants.ERROR, JOptionPane.ERROR_MESSAGE);
    }
}
