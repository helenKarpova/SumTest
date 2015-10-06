import java.util.Scanner;
import java.awt.Point;

public class StartPoint {

	public static void main(String[] args) {

		Point[] points = GetPoints();

		if (points == null || points.length == 0) {
			return;
		}

		double minDistance = 0;
		double distance = 0;

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					distance = Point.distance(points[i].x, points[i].y, points[j].x, points[j].y);
					if (i == 0) {
						minDistance = distance;
					} else {
						if (minDistance > distance) {
							minDistance = distance;
						}
					}
				}
			}
		}

		System.out.println("Минимальное расстояние между точками = " + minDistance);
	}

	private static Point[] GetPoints() {
		try (Scanner inp = new Scanner(System.in)) {
			System.out.print("Введите количество точек (минимальное значение 2) = : ");
			int pointCount = inp.nextInt();

			if (pointCount < 2) {
				System.out.println("Ошибка! Кол-во точек должно быть больше одной.");
				return null;
			}

			Point[] line = new Point[pointCount];

			for (int i = 0; i < line.length; i++) {
				System.out.println("Введите координаты точки : ");

				System.out.print("Введите x : ");
				int a = inp.nextInt();
				System.out.print("Введите y: ");
				int b = inp.nextInt();
				line[i] = new Point(a, b);
			}

			return line;
		}
	}
}