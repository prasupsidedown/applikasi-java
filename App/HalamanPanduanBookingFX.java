package App;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class HalamanPanduanBookingFX extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Panduan Booking - Sistem Registrasi Pendakian Gunung Merbabu");

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: white;");

        // ===== NAVBAR =====
        HBox navbar = new HBox(50);
        navbar.setPadding(new Insets(15, 0, 15, 0));
        navbar.setAlignment(Pos.CENTER);
        navbar.setBackground(new Background(new BackgroundFill(Color.rgb(183, 175, 163), CornerRadii.EMPTY, Insets.EMPTY)));
        navbar.setBorder(new Border(new BorderStroke(Color.rgb(160, 150, 140), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        String[] menuItems = {"Beranda", "Panduan Booking", "Panduan Pembayaran", "Cek Booking", "Login"};
        for (String item : menuItems) {
            Button btn = new Button(item);
            btn.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
            btn.setOnAction(e -> {
                // Ganti sesuai navigasi antar halaman
                Alert alert = new Alert(Alert.AlertType.INFORMATION, item + " diklik");
                alert.showAndWait();
            });
            navbar.getChildren().add(btn);
        }

        root.setTop(navbar);

        // ===== CONTAINER UTAMA =====
        VBox container = new VBox(20);
        container.setAlignment(Pos.TOP_LEFT);
        container.setPadding(new Insets(30, 50, 30, 50));
        container.setBackground(new Background(new BackgroundFill(Color.web("#a49c93"), new CornerRadii(10), Insets.EMPTY)));

        Label title = new Label("Panduan Booking");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        title.setTextFill(Color.WHITE);

        TextArea textArea = new TextArea("""
            1. Buka website resmi Sistem Pendakian Gunung Merbabu.
            2. Pilih menu 'Panduan Booking' untuk membaca tata cara pendaftaran.
            3. Klik tombol 'Booking' di halaman utama.
            4. Isi data pendaki sesuai identitas yang berlaku.
            5. Lakukan pembayaran sesuai petunjuk yang tersedia.
            6. Simpan bukti pembayaran dan tunggu verifikasi.
        """);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setStyle("-fx-font-size: 15px; -fx-control-inner-background: transparent; -fx-text-fill: white; -fx-border-color: transparent;");

        Button btnKembali = new Button("Kembali");
        btnKembali.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        btnKembali.setPrefWidth(120);
        btnKembali.setPrefHeight(40);
        btnKembali.setStyle("-fx-background-color: white; -fx-text-fill: black;");
        btnKembali.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Kembali ke halaman utama");
            alert.showAndWait();
        });

        container.getChildren().addAll(title, textArea, btnKembali);

        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");

        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 1200, 700);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
