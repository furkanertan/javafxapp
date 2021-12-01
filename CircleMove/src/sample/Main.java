package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.util.Duration;

import java.util.*;

public class Main extends Application {
    List<Circle> circleList = new ArrayList<Circle>();
    int redIndex = 0;
    boolean isAnimating = false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setHeight(500);
        primaryStage.setWidth(450);
        initCircles();
        Button turnButton = new Button("DÖNDÜR");
        turnButton.setLayoutX(100);
        turnButton.setLayoutY(400);
        turnButton.setOnAction((ActionEvent event) -> {
            final Animation animation = new Transition() {

                {
                    setCycleDuration(Duration.millis(0.1));
                    setInterpolator(Interpolator.EASE_OUT);
                }

                @Override
                protected void interpolate(double frac) {
                    turnCircles();
                }
            };
            animation.play();
        });
        Button autoButton = new Button("OTOMATİK");
        autoButton.setLayoutX(170);
        autoButton.setLayoutY(400);
        autoButton.setOnAction((ActionEvent event) -> {
            final Animation animation = new Transition() {
                {
                        setCycleDuration(Duration.INDEFINITE);
                        setInterpolator(Interpolator.EASE_OUT);
                }

                @Override
                protected void interpolate(double frac) {
                        turnCircles();
                }
            };
                if(isAnimating){
                    System.out.println("animation.stop");
                    animation.stop();
                    isAnimating = false;
                }else {
                    animation.setDelay(Duration.millis(1000));
                    animation.play();
                    isAnimating = true;
                }
        });
        Button exitButton = new Button("KAPAT");
        exitButton.setLayoutX(250);
        exitButton.setLayoutY(400);
        exitButton.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        Circle circleMid = new Circle();
        circleMid.setCenterX(200.0f);
        circleMid.setCenterY(200.0f);
        circleMid.setRadius(20.0f);
        circleMid.setFill(Color.BLUE);
        circleMid.setStroke(Color.BLACK);
        Group root = new Group(turnButton,autoButton,exitButton,circleMid);
        root.getChildren().addAll(circleList);
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Daire Döndürme");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initCircles(){
        Circle circle1 = new Circle();
        circle1.setCenterX(200.0f);
        circle1.setCenterY(50.0f);
        circle1.setRadius(20.0f);
        circle1.setFill(Color.RED);
        circle1.setStroke(Color.BLACK);
        circleList.add(circle1);
        Circle circle2 = new Circle();
        circle2.setCenterX(300.0f);
        circle2.setCenterY(100.0f);
        circle2.setRadius(20.0f);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);
        circleList.add(circle2);
        Circle circle3 = new Circle();
        circle3.setCenterX(350.0f);
        circle3.setCenterY(200.0f);
        circle3.setRadius(20.0f);
        circle3.setFill(Color.WHITE);
        circle3.setStroke(Color.BLACK);
        circleList.add(circle3);
        Circle circle4 = new Circle();
        circle4.setCenterX(300.0f);
        circle4.setCenterY(300.0f);
        circle4.setRadius(20.0f);
        circle4.setFill(Color.WHITE);
        circle4.setStroke(Color.BLACK);
        circleList.add(circle4);
        Circle circle5 = new Circle();
        circle5.setCenterX(200.0f);
        circle5.setCenterY(350.0f);
        circle5.setRadius(20.0f);
        circle5.setFill(Color.WHITE);
        circle5.setStroke(Color.BLACK);
        circleList.add(circle5);
        Circle circle6 = new Circle();
        circle6.setCenterX(100.0f);
        circle6.setCenterY(300.0f);
        circle6.setRadius(20.0f);
        circle6.setFill(Color.WHITE);
        circle6.setStroke(Color.BLACK);
        circleList.add(circle6);
        Circle circle7 = new Circle();
        circle7.setCenterX(50.0f);
        circle7.setCenterY(200.0f);
        circle7.setRadius(20.0f);
        circle7.setFill(Color.WHITE);
        circle7.setStroke(Color.BLACK);
        circleList.add(circle7);
        Circle circle8 = new Circle();
        circle8.setCenterX(100.0f);
        circle8.setCenterY(100.0f);
        circle8.setRadius(20.0f);
        circle8.setFill(Color.WHITE);
        circle8.setStroke(Color.BLACK);
        circleList.add(circle8);
    }

    public void turnCircles(){
        if(redIndex==circleList.size()-1){
            circleList.get(0).setFill(Color.RED);
            circleList.get(redIndex).setFill(Color.WHITE);
            redIndex = 0;
        }else{
            circleList.get(redIndex+1).setFill(Color.RED);
            circleList.get(redIndex).setFill(Color.WHITE);
            redIndex +=1;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
