import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChessGUI extends JFrame {
    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 64;
    private BufferedImage[] pieceImages = new BufferedImage[12]; // Adjust the size according to the number of pieces

    private Position originPosition;
    private Position destinationPosition;

    // Add a flag to track if it's the first or second touch
    private boolean isFirstTouch = true;
    private Board board;

    public ChessGUI() {
        setTitle("Chess Game");
        setSize(BOARD_SIZE * SQUARE_SIZE + 16, BOARD_SIZE * SQUARE_SIZE + 39); // Adjusted window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new Board();

        loadPieceImages();
        JPanel chessboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBoard(g);
                drawPieces(g);
            }
        };

        chessboardPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / SQUARE_SIZE + 1;
                int y = (BOARD_SIZE - 1) - (e.getY() / SQUARE_SIZE) + 1;

                if (isFirstTouch) {
                    originPosition = new Position(x, y);
                    System.out.println("Origin: " + originPosition);
                    isFirstTouch = false;
                } else {
                    destinationPosition = new Position(x, y);
                    System.out.println("Destination: " + destinationPosition);

                    board.move(originPosition, destinationPosition);

                    originPosition = null;
                    destinationPosition = null;
                    isFirstTouch = true;
                }

                repaint();
            }
        });

        add(chessboardPanel);
    }

    private void drawBoard(Graphics g) {
        boolean white = true;
        for (int y = BOARD_SIZE - 1; y >= 0; y--) { // Start drawing from the bottom row
            for (int x = 0; x < BOARD_SIZE; x++) { // Start from the left-most column
                if (white) {
                    g.setColor(Color.GRAY);
                } else {
                    g.setColor(Color.BLUE);
                }
                g.fillRect(x * SQUARE_SIZE, y * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                white = !white;
            }
            white = !white;
        }
    }

    private void drawPieces(Graphics g) {
        for (int row = 1; row <= BOARD_SIZE; row++) {
            for (int col = 1; col <= BOARD_SIZE; col++) {
                Position position = new Position(col, row);
                Piece piece = board.findPieceAtPosition(position);
                if (piece != null) {

                    if(piece.getTeam() == 0) {
                        BufferedImage image = pieceImages[piece.getId() - 1];
                        g.drawImage(image, (col - 1) * SQUARE_SIZE, (BOARD_SIZE - row) * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, null);
                    }
                    if(piece.getTeam() == 1) {
                        BufferedImage image = pieceImages[(piece.getId() + 5)];
                        g.drawImage(image, (col - 1) * SQUARE_SIZE, (BOARD_SIZE - row) * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, null);
                    }
                }
            }
        }
    }
    private void loadPieceImages() {
        try {
            // Load images for white pieces
            pieceImages[0] = ImageIO.read(new File("PiecesPNG/whitePawn.png"));
            pieceImages[1] = ImageIO.read(new File("PiecesPNG/whiteBishop.png"));
            pieceImages[2] = ImageIO.read(new File("PiecesPNG/whiteHorse.png"));
            pieceImages[3] = ImageIO.read(new File("PiecesPNG/whiteRook.png"));
            pieceImages[4] = ImageIO.read(new File("PiecesPNG/whiteQueen.png"));
            pieceImages[5] = ImageIO.read(new File("PiecesPNG/whiteKing.png"));
            // Load images for black pieces
            pieceImages[6] = ImageIO.read(new File("PiecesPNG/blackPawn.png"));
            pieceImages[7] = ImageIO.read(new File("PiecesPNG/blackBishop.png"));
            pieceImages[8] = ImageIO.read(new File("PiecesPNG/blackHorse.png"));
            pieceImages[9] = ImageIO.read(new File("PiecesPNG/blackRook.png"));
            pieceImages[10] = ImageIO.read(new File("PiecesPNG/blackQueen.png"));
            pieceImages[11] = ImageIO.read(new File("PiecesPNG/blackKing.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
