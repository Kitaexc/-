    import java.util.Scanner;
    
    abstract class Figure {
        public abstract double ravnoPloh();
        public abstract double ravnoPerimetr();
    }
    
    class krug extends Figure {
        double radius;
    
        krug(double radius) {
            this.radius = radius;
        }
    
        @Override
        public double ravnoPloh() {
            return Math.PI * radius * radius;
        }
    
        @Override
        public double ravnoPerimetr() {
            return 2 * Math.PI * radius;
        }
    }
    
    class Kvadrat extends Figure {
        double storona;
    
        Kvadrat(double storona) {
            this.storona = storona;
        }
    
        @Override
        public double ravnoPloh() {
            return storona * storona;
        }
    
        @Override
        public double ravnoPerimetr() {
            return 4 * storona;
        }
    }
    
    class Treugolnik extends Figure {
        double a, b, c; // Стороны треугольника
    
        Treugolnik(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    
        @Override
        public double ravnoPloh() {
            // Вычисление площади треугольника по формуле Герона
            double s = (a + b + c) / 2.0;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
    
        @Override
        public double ravnoPerimetr() {
            return a + b + c;
        }
    }
    
    class Patiugolnik extends Figure {
        double storona; // Длина стороны пятиугольника
    
        Patiugolnik(double storona) {
            this.storona = storona;
        }
    
        @Override
        public double ravnoPloh() {
            // Площадь правильного пятиугольника через длину стороны
            double apothem = storona / (2 * Math.tan(Math.PI / 5));
            return (5 * storona * apothem) / 2;
        }
    
        @Override
        public double ravnoPerimetr() {
            // Периметр пятиугольника
            return 5 * storona;
        }
    }
    
    class Trapeziya extends Figure {
        double a, b, c, d, h; // Длины оснований, боковых сторон и высоты
    
        Trapeziya(double a, double b, double c, double d, double h) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.h = h;
        }
    
        @Override
        public double ravnoPloh() {
            // Площадь трапеции
            return (a + b) / 2 * h;
        }
    
        @Override
        public double ravnoPerimetr() {
            // Периметр трапеции
            return a + b + c + d;
        }
    }
    
    class Pryamougolnik extends Figure {
        double a, b; // Длины сторон прямоугольника
    
        Pryamougolnik(double a, double b) {
            this.a = a;
            this.b = b;
        }
    
        @Override
        public double ravnoPloh() {
            // Площадь прямоугольника
            return a * b;
        }
    
        @Override
        public double ravnoPerimetr() {
            // Периметр прямоугольника
            return 2 * (a + b);
        }
    }
    
    class Parallelogramm extends Figure {
        double a, h; // Длина стороны и высота, опущенная на эту сторону
        double b; // Длина смежной стороны
    
        Parallelogramm(double a, double b, double h) {
            this.a = a;
            this.b = b;
            this.h = h;
        }
    
        @Override
        public double ravnoPloh() {
            // Площадь параллелограмма
            return a * h;
        }
    
        @Override
        public double ravnoPerimetr() {
            // Периметр параллелограмма
            return 2 * (a + b);
        }
    }
    class Parallelepipid extends Figure {
        double length, width, height; // Длина, ширина и высота параллелепипеда
    
        Parallelepipid(double length, double width, double height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }
    
        @Override
        public double ravnoPloh() {
            // Площадь поверхности параллелепипеда
            return 2 * (length * width + width * height + height * length);
        }
    
        @Override
        public double ravnoPerimetr() {
            // Периметр в базовом классе Figure означает периметр основания.
            // Для параллелепипеда более релевантно вычислить объём, поэтому используем этот метод для объёма.
            return length * width * height;
        }
    }
    
    class Cilindr extends Figure {
        double radius, height; // Радиус и высота цилиндра
    
        Cilindr(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }
    
        @Override
        public double ravnoPloh() {
            // Площадь поверхности цилиндра: 2*π*r*(r + h)
            return 2 * Math.PI * radius * (radius + height);
        }
    
        @Override
        public double ravnoPerimetr() {
            // Объём цилиндра: π*r^2*h
            // Здесь метод используется не по назначению для демонстрации объёма.
            return Math.PI * radius * radius * height;
        }
    }
    
    class Sfera extends Figure {
        double radius; // Радиус сферы
    
        Sfera(double radius) {
            this.radius = radius;
        }
    
        @Override
        public double ravnoPloh() {
            // Площадь поверхности сферы: 4*π*r^2
            return 4 * Math.PI * radius * radius;
        }
    
        @Override
        public double ravnoPerimetr() {
            // Объём сферы: (4/3)*π*r^3
            // Использование метода ravnoPerimetr для объёма демонстрирует отход от первоначального предназначения.
            return (4.0 / 3) * Math.PI * radius * radius * radius;
        }
    }
    
    class Romb extends Figure {
        double d1, d2; // Длины диагоналей ромба
    
        Romb(double d1, double d2) {
            this.d1 = d1;
            this.d2 = d2;
        }
    
        @Override
        public double ravnoPloh() {
            // Площадь ромба через диагонали: 0.5 * d1 * d2
            return 0.5 * d1 * d2;
        }
    
        @Override
        public double ravnoPerimetr() {
            // Периметр ромба: 4*a. Но a можно вычислить через диагонали
            double a = Math.sqrt((d1 * d1 + d2 * d2) / 2);
            return 4 * a;
        }
    }
    
    class Konus extends Figure {
        double radius, height; // Радиус основания и высота конуса
    
        Konus(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }
    
        @Override
        public double ravnoPloh() {
            // Площадь поверхности конуса: π*r*(r + l), где l - образующая, l = sqrt(r^2 + h^2)
            double l = Math.sqrt(radius * radius + height * height);
            return Math.PI * radius * (radius + l);
        }
    
        @Override
        public double ravnoPerimetr() {
            // Объём конуса: (1/3)*π*r^2*h
            // Метод переименован для демонстрации объёма, несмотря на его первоначальное назначение.
            return (1.0 / 3) * Math.PI * radius * radius * height;
        }
    }
    
    public class Prakt4 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите фигуру:\n1 - Круг\n2 - Квадрат\n3 - Треугольник\n4 - Пятиугольник\n5 - Трапеция\n6 - Прямоугольник\n7 - Параллелограмм\n8 - Параллелепипед\n9 - Цилиндр\n10 - Сфера\n11 - Ромб\n12 - Конус");
            int vibor = scanner.nextInt();
    
            Figure Figure = null;
            switch (vibor) {
                case 1:
                    System.out.println("Введите радиус круга:");
                    double radius = scanner.nextDouble();
                    Figure = new krug(radius);
                    break;
                case 2:
                    System.out.println("Введите длину стороны квадрата:");
                    double storona = scanner.nextDouble();
                    Figure = new Kvadrat(storona);
                    break;
                case 3:
                    System.out.println("Введите длину стороны a треугольника:");
                    double a = scanner.nextDouble();
                    System.out.println("Введите длину стороны b треугольника:");
                    double b = scanner.nextDouble();
                    System.out.println("Введите длину стороны c треугольника:");
                    double c = scanner.nextDouble();
                    Figure = new Treugolnik(a, b, c);
                    break;
                case 4:
                    System.out.println("Введите длину стороны пятиугольника:");
                    double storona1 = scanner.nextDouble();
                    Figure = new Patiugolnik(storona1);
                    break;
                case 5:
                    System.out.println("Введите длину основания a трапеции:");
                    double a1 = scanner.nextDouble();
                    System.out.println("Введите длину основания b трапеции:");
                    double b1 = scanner.nextDouble();
                    System.out.println("Введите длину боковой стороны c трапеции:");
                    double c1 = scanner.nextDouble();
                    System.out.println("Введите длину боковой стороны d трапеции:");
                    double d1 = scanner.nextDouble();
                    System.out.println("Введите высоту h трапеции:");
                    double h1 = scanner.nextDouble();
                    Figure = new Trapeziya(a1, b1, c1, d1, h1);
                    break;
                case 6:
                    System.out.println("Введите длину стороны a прямоугольника:");
                    double a2 = scanner.nextDouble();
                    System.out.println("Введите длину стороны b прямоугольника:");
                    double b2 = scanner.nextDouble();
                    Figure = new Pryamougolnik(a2, b2);
                    break;
                case 7:
                    System.out.println("Введите длину стороны a параллелограмма:");
                    double a3 = scanner.nextDouble();
                    System.out.println("Введите длину смежной стороны b параллелограмма:");
                    double b3 = scanner.nextDouble();
                    System.out.println("Введите высоту h, опущенную на сторону a:");
                    double h2 = scanner.nextDouble();
                    Figure = new Parallelogramm(a3, b3, h2);
                    break;
                case 8:
                    System.out.println("Введите длину параллелепипеда:");
                    double length = scanner.nextDouble();
                    System.out.println("Введите ширину параллелепипеда:");
                    double width = scanner.nextDouble();
                    System.out.println("Введите высоту параллелепипеда:");
                    double height = scanner.nextDouble();
                    Figure = new Parallelepipid(length, width, height);
                    break;
                case 9:
                    System.out.println("Введите радиус цилиндра:");
                    double radius1 = scanner.nextDouble();
                    System.out.println("Введите высоту цилиндра:");
                    double height1 = scanner.nextDouble();
                    Figure = new Cilindr(radius1, height1);
                    break;
                case 10:
                    System.out.println("Введите радиус сферы:");
                    double radius2 = scanner.nextDouble();
                    Figure = new Sfera(radius2);
                    break;
                case 11:
                    System.out.println("Введите длину диагонали d1 ромба:");
                    double d11 = scanner.nextDouble();
                    System.out.println("Введите длину диагонали d2 ромба:");
                    double d22 = scanner.nextDouble();
                    Figure = new Romb(d11, d22);
                    break;
                case 12:
                    System.out.println("Введите радиус основания конуса:");
                    double radius3 = scanner.nextDouble();
                    System.out.println("Введите высоту конуса:");
                    double height3 = scanner.nextDouble();
                    Figure = new Konus(radius3, height3);
                    break;
    
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
    
            if (Figure != null) {
                System.out.println("Площадь фигуры: " + Figure.ravnoPloh());
                System.out.println("Периметр фигуры: " + Figure.ravnoPerimetr());
            }
        }
    }
