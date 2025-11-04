package App;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;

public class HalamanLoginFX extends Application {

    @Override
    public void start(Stage stage) {
        // === Background ===
        File imgFile = new File("images/login.png");
        BackgroundImage bgImage = null;

        if (imgFile.exists()) {
            Image image = new Image(imgFile.toURI().toString());
            bgImage = new BackgroundImage(
                    image,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(100, 100, true, true, true, false)
            );
        } else {
            System.err.println("⚠️ Gambar tidak ditemukan: " + imgFile.getAbsolutePath());
        }

        Pane root = new Pane();
        if (bgImage != null) {
            root.setBackground(new Background(bgImage));
        } else {
            root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        }

        // === Tombol Login ===
        Button btnLogin = new Button("LOGIN");
        btnLogin.setFont(Font.font("Poppins", 18));
        btnLogin.getStyleClass().add("login-button"); // pakai CSS class

        // Posisi tombol kiri bawah
        btnLogin.setLayoutX(40);
        btnLogin.setLayoutY(420);

        root.getChildren().add(btnLogin);

        // Aksi tombol login
        btnLogin.setOnAction(e -> {
            Stage s = (Stage) btnLogin.getScene().getWindow();
            s.close();
            try {
                new HalamanUtama().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // === Scene dan CSS ===
        Scene scene = new Scene(root, 900, 500);
        scene.getStylesheets().add(new File("login.css").toURI().toString());

        stage.setTitle("Login - Sistem Registrasi Pendakian");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
