package testrectangle;


public class TestRectangle {

    
    public static void main(String[] args) {
       PointR2 p1 = new PointR2(0, 0);
        PointR2 p2 = new PointR2(4, 3);

        Rectangle rect1 = new Rectangle(p1, p2);
        System.out.println("Rectangle 1 : " + rect1);
        System.out.println("Longueur : " + rect1.longueur());
        System.out.println("Hauteur : " + rect1.hauteur());
        System.out.println("Périmètre : " + rect1.perimetre());
        System.out.println("Surface : " + rect1.surface());

        PointR2 p3 = new PointR2(2, 1);
        System.out.println("Le rectangle contient le point " + p3 + " : " + rect1.contient(p3));

        Rectangle sym = rect1.symetrique();
        System.out.println("Rectangle symétrique : " + sym);
    }
}
    
    

