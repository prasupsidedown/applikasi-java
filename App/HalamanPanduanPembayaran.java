package App;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HalamanPanduanPembayaran extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Panduan Pembayaran - Sistem Registrasi Pendakian");

        // ===== ROOT (background abu muda) =====
        BorderPane root = new BorderPane();
        root.setPrefSize(1200, 800);
        root.setBackground(new Background(new BackgroundFill(Color.rgb(245, 245, 245), CornerRadii.EMPTY, Insets.EMPTY)));

        // ===== NAVBAR =====
        HBox navbar = new HBox(80);
        navbar.setAlignment(Pos.CENTER);
        navbar.setPadding(new Insets(10));
        navbar.setBackground(new Background(new BackgroundFill(Color.web("#B7AFA3"), new CornerRadii(10), Insets.EMPTY)));
        navbar.setBorder(new Border(new BorderStroke(Color.web("#A0968C"),
                BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
        navbar.setPrefHeight(60);
        navbar.setMaxWidth(1100);

        String[] menuItems = {"Beranda", "Panduan Booking", "Panduan Pembayaran", "Cek Booking", "Login"};
        for (String item : menuItems) {
            Button btn = new Button(item);
            btn.setFont(Font.font("Poppins", 14));
            btn.setCursor(Cursor.HAND);
            btn.setStyle("-fx-background-color: #B7AFA3; -fx-border-color: transparent;");
            btn.setOnAction(e -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(item + " diklik");
                alert.showAndWait();
            });
            navbar.getChildren().add(btn);
        }

        VBox navbarContainer = new VBox();
        navbarContainer.setAlignment(Pos.TOP_CENTER);
        navbarContainer.setPadding(new Insets(20, 0, 0, 0));
        navbarContainer.getChildren().add(navbar);

        root.setTop(navbarContainer);

        // ===== KONTEN PUTIH =====
        VBox container = new VBox(20);
        container.setAlignment(Pos.TOP_LEFT);
        container.setPadding(new Insets(20, 40, 20, 40));
        container.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        container.setPrefSize(980, 620);
        container.setMaxWidth(980);

        Label title = new Label("Panduan Pembayaran");
        title.setFont(Font.font("Poppins", 26));
        title.setTextFill(Color.BLACK);

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setFont(Font.font("Arial", 15));
        textArea.setStyle("-fx-control-inner-background: transparent; -fx-text-fill: #333333;");
        textArea.setText("""
                Pembayaran Melalui Bank Jatim
                --------------------------------
                • Melalui Transfer ATM:
                  1. Pada ATM Bank Jatim, pilih menu Pembayaran
                  2. Pilih lainnya
                  3. Pilih Virtual Account
                  4. Masukkan nomor Bank Jatim Virtual Account
                  5. Lakukan konfirmasi pembayaran anda
                  6. Transaksi selesai

                • Melalui Mobile Banking Bank Jatim:
                  1. Login ke aplikasi JConnect Mobile
                  2. Pilih menu Bayar → Virtual Account
                  3. Masukkan Nomor Virtual Account
                  4. Masukkan PIN anda
                  5. Transaksi selesai

                Pembayaran Melalui Bank Mandiri
                --------------------------------
                • Melalui Transfer ATM:
                  1. Masukkan kartu di mesin ATM Bank Mandiri
                  2. Masukkan PIN anda
                  3. Pilih Transaksi Lainnya → Transfer → Antar Bank
                  4. Masukkan Kode Bank Jatim 114 + nomor Virtual Account
                  5. Masukkan nominal sesuai tagihan, lalu konfirmasi
                  6. Transaksi selesai

                • Melalui Mobile Banking:
                  1. Login ke Livin' by Mandiri
                  2. Pilih Transfer → Penerima Baru → Bank BPD Jatim
                  3. Masukkan Nomor Virtual Account
                  4. Masukkan nominal sesuai tagihan dan PIN anda
                  5. Transaksi selesai

                Pembayaran Melalui Bank BCA
                -----------------------------
                • Melalui ATM:
                  1. Masukkan kartu di mesin ATM BCA
                  2. Masukkan PIN
                  3. Pilih Transaksi Lainnya → Transfer → Ke Rekening Bank Lain
                  4. Masukkan Kode Bank Jatim 114 + Nomor Virtual Account
                  5. Masukkan nominal dan konfirmasi

                • Melalui Mobile Banking:
                  1. Login ke BCA Mobile
                  2. Pilih m-Transfer → Antar Bank
                  3. Pilih Bank Jatim dan masukkan Nomor Virtual Account
                  4. Masukkan nominal dan PIN
                  5. Transaksi selesai

                Pembayaran Melalui Bank CIMB Niaga
                -----------------------------------
                • Melalui ATM:
                  1. Masukkan kartu di mesin ATM CIMB Niaga
                  2. Masukkan PIN → Transfer → Bank Lain
                  3. Masukkan Kode Bank Jatim 114 + Nomor Virtual Account
                  4. Konfirmasi dan selesai

                • Melalui Mobile Banking:
                  1. Login ke OCTO Mobile
                  2. Pilih Transfer → Bank Lainnya → Bank Jatim
                  3. Masukkan Nomor Virtual Account dan nominal
                  4. Masukkan PIN → Transaksi selesai

                Pembayaran Melalui Bank Lainnya
                --------------------------------
                • Melalui ATM:
                  1. Masukkan kartu → PIN → Transfer → Bank Lain
                  2. Masukkan Kode Bank Jatim 114 + Nomor Virtual Account
                  3. Konfirmasi dan selesai

                • Melalui Mobile Banking:
                  1. Login ke mobile banking bank anda
                  2. Pilih Transfer → Bank Lainnya → Bank Jatim
                  3. Masukkan Nomor Virtual Account dan nominal
                  4. Pilih metode transfer Realtime/Online
                  5. Masukkan PIN → Transaksi selesai
                """);

        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setPannable(true);
        scrollPane.setStyle("-fx-background-color:transparent;");
        scrollPane.setVvalue(0);

        container.getChildren().addAll(title, scrollPane);

        VBox contentWrapper = new VBox(container);
        contentWrapper.setAlignment(Pos.CENTER);
        contentWrapper.setPadding(new Insets(20, 0, 20, 0));

        root.setCenter(contentWrapper);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
