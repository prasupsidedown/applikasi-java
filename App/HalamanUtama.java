package App;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class HalamanUtama extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sistem Registrasi Pendakian");

        // ===== Background =====
        File imgFile = new File("images/background.png");
        Image bgImage = null;
        if (imgFile.exists()) {
            bgImage = new Image(imgFile.toURI().toString(), 1200, 700, false, true);
        } else {
            System.err.println("⚠️ Gambar tidak ditemukan: " + imgFile.getAbsolutePath());
        }

        BackgroundImage bg = new BackgroundImage(
                bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        StackPane root = new StackPane();
        root.setPrefSize(1200, 700);
        root.setBackground(new Background(bg));

        // ===== Navbar =====
        HBox navbar = new HBox();
        navbar.setPadding(new Insets(10, 40, 10, 40));
        navbar.setAlignment(Pos.CENTER);
        navbar.getStyleClass().add("navbar");

        // Bagian kiri
        Button btnTNGM = new Button("TNGM");
        btnTNGM.getStyleClass().add("navbar-button");
        btnTNGM.setCursor(Cursor.HAND);

        // Bagian kanan
        HBox rightMenu = new HBox(50);
        rightMenu.setAlignment(Pos.CENTER_RIGHT);

        Button btnPanduanBooking = new Button("Panduan Booking");
        Button btnPanduanPembayaran = new Button("Panduan Pembayaran");
        Button btnLogin = new Button("Login");

        Button[] rightButtons = {btnPanduanBooking, btnPanduanPembayaran, btnLogin};
        for (Button b : rightButtons) {
            b.getStyleClass().add("navbar-button");
            b.setCursor(Cursor.HAND);
        }

        rightMenu.getChildren().addAll(rightButtons);
        HBox.setHgrow(rightMenu, Priority.ALWAYS);

        navbar.getChildren().addAll(btnTNGM, rightMenu);

        VBox navContainer = new VBox(navbar);
        navContainer.setAlignment(Pos.TOP_CENTER);
        navContainer.setPadding(new Insets(40, 0, 0, 0));

        // ===== Konten Tengah =====
        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.TOP_LEFT);
        contentBox.setPadding(new Insets(220, 0, 0, 100));

        Label judul = new Label("Gunung Merbabu");
        judul.getStyleClass().add("title-text");

        Label deskripsi = new Label("Puncak Merbabu dikenal dengan nama puncak Kenteng Songo\n" +
                "dengan ketinggian 3.142 mdpl.");
        deskripsi.getStyleClass().add("desc-text");

        contentBox.getChildren().addAll(judul, deskripsi);

        // ===== Tombol bawah =====
        Button btnBooking = new Button("Booking");
        Button btnStatus = new Button("Status Booking");

        for (Button b : new Button[]{btnBooking, btnStatus}) {
            b.getStyleClass().add("action-button");
            b.setCursor(Cursor.HAND);
        }

        HBox bottomPanel = new HBox(20, btnBooking, btnStatus);
        bottomPanel.setAlignment(Pos.CENTER_LEFT);
        bottomPanel.setPadding(new Insets(0, 0, 0, 100));
        bottomPanel.setTranslateY(400);

        // ===== Aksi tombol =====
        btnPanduanBooking.setOnAction(e -> {
            System.out.println("Buka Halaman Panduan Booking...");
        });

        btnPanduanPembayaran.setOnAction(e -> {
            System.out.println("Buka Halaman Panduan Pembayaran...");
        });

        btnLogin.setOnAction(e -> {
            System.out.println("Kembali ke Halaman Login...");
        });

        btnBooking.setOnAction(e -> {
            System.out.println("Buka halaman Booking...");
        });

        btnStatus.setOnAction(e -> {
            System.out.println("Buka halaman Status Booking...");
        });

        // ===== Susun semua ke root =====
        root.getChildren().addAll(navContainer, contentBox, bottomPanel);

        Scene scene = new Scene(root, 1200, 700);
        scene.getStylesheets().add(getClass().getResource("utama.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
