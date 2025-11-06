package org.example.plugin;

import com.example.Circle;
import com.example.Rectangle;
import com.example.Shape2D;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "compare-shapes")
public class MyGeometryUtilsMojo extends AbstractMojo {

    @Parameter(property = "shape1Type", defaultValue = "circle")
    private String shape1Type;

    @Parameter(property = "shape1Size", defaultValue = "5")
    private double shape1Size;

    @Parameter(property = "shape2Type", defaultValue = "rectangle")
    private String shape2Type;

    @Parameter(property = "shape2Width", defaultValue = "4")
    private double shape2Width;

    @Parameter(property = "shape2Height", defaultValue = "6")
    private double shape2Height;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        // Фигура 1
        getLog().info("=== Shape 1 ===");
        Shape2D s1 = createShape(shape1Type, shape1Size, 0);
        printShapeInfo(s1, shape1Type, shape1Size, 0);

        // Фигура 2
        getLog().info("=== Shape 2 ===");
        Shape2D s2 = createShape(shape2Type, shape2Width, shape2Height);
        printShapeInfo(s2, shape2Type, shape2Width, shape2Height);
    }

    private Shape2D createShape(String type, double param1, double param2) throws MojoExecutionException {
        switch (type.toLowerCase()) {
            case "circle":
                return new Circle(param1);
            case "rectangle":
                return new Rectangle(param1, param2);
            default:
                throw new MojoExecutionException("Unknown shape type: " + type);
        }
    }

    private void printShapeInfo(Shape2D shape, String type, double param1, double param2) {
        double area = shape.area();
        double perimeter = shape.perimeter();
        getLog().info("Shape: " + type);
        if ("circle".equalsIgnoreCase(type)) {
            getLog().info("Radius: " + param1);
        } else if ("rectangle".equalsIgnoreCase(type)) {
            getLog().info("Width: " + param1 + ", Height: " + param2);
        }
        getLog().info("Area: " + area);
        getLog().info("Perimeter: " + perimeter);
    }
}