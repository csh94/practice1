package csh.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.stage.Stage;

public class ��Ʈ���� extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("[�̷�����] ���� ��� ������ �ð�ȭ ���α׷� - RainFall Visualizer");
		final CategoryAxis xAxis = new CategoryAxis(); //x�� ��ü ����
		final NumberAxis yAxis = new NumberAxis(); //y�� ��ü ����
		xAxis.setLabel("Month"); //x�� ���� �̸��ֱ�
		yAxis.setLabel("Rainfall(ml"); //y�� ���� �̸��ֱ�
		final BarChart<String, Number> BarChart = 
				new BarChart<String, Number>(xAxis, yAxis);//�⺻ ����Ʈ ����
		BarChart.setTitle("The RainFall Distribution on Seoul in 2016");//��Ʈ ū�̸� �ֱ�
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>(); //�������� �ø��� ����
		series1.setName("Rainfall Volume(ml)"); //���� �̸� ����      
		series1.getData().add(new Data<String, Number>("Jan", 1));
		series1.getData().add(new Data<String, Number>("Feb", 47.6));
		series1.getData().add(new Data<String, Number>("Mar", 40.5));
		series1.getData().add(new Data<String, Number>("Apr", 76.8));
		series1.getData().add(new Data<String, Number>("May", 160.5));
		series1.getData().add(new Data<String, Number>("Jun", 54.4));
		series1.getData().add(new Data<String, Number>("Jul", 358.2));
		series1.getData().add(new Data<String, Number>("Aug", 67.1));
		series1.getData().add(new Data<String, Number>("Sep", 33));
		series1.getData().add(new Data<String, Number>("Oct", 74.8));
		series1.getData().add(new Data<String, Number>("Nov", 16.7));
		series1.getData().add(new Data<String, Number>("Dec", 61.1));
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>(); //�����ϼ��� �ø��� ����
		series2.setName("Rainy Days(day)"); //���� �̸� ����    
		series2.getData().add(new Data<String, Number>("Jan", 4));
		series2.getData().add(new Data<String, Number>("Feb", 8));
		series2.getData().add(new Data<String, Number>("Mar", 5));
		series2.getData().add(new Data<String, Number>("Apr", 10));
		series2.getData().add(new Data<String, Number>("May", 9));
		series2.getData().add(new Data<String, Number>("Jun", 8));
		series2.getData().add(new Data<String, Number>("Jul", 17));
		series2.getData().add(new Data<String, Number>("Aug", 11));
		series2.getData().add(new Data<String, Number>("Sep", 7));
		series2.getData().add(new Data<String, Number>("Oct", 9));
		series2.getData().add(new Data<String, Number>("Nov", 11));
		series2.getData().add(new Data<String, Number>("Dec", 10));
		Scene scene = new Scene(BarChart,800,600);
		BarChart.getData().add(series1);//����Ʈ�� ������ ������ ����
		BarChart.getData().add(series2);//����Ʈ�� �����ϼ� ������ ����
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
