package org.example.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "compute-geometry-2d")
public class My2DGeometryMojo extends AbstractMojo {

    @Parameter(property = "shape", defaultValue = "circle")
    private String shape;

    @Parameter(property = "radius", defaultValue = "5")
    private double radius;

    @Parameter(property = "width", defaultValue = "4")
    private double width;
    @Parameter(property = "height", defaultValue = "6")
    private double height;

    @Parameter(property = "a", defaultValue = "3")
    private double a;
    @Parameter(property = "b", defaultValue = "4")
    private double c;
    @Parameter(property = "c", defaultValue = "5")
    private double b;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        switch (shape.toLowerCase()) {
            case "circle":
                getLog().info("Shape: Circle");
                getLog().info("Radius: " + radius);
                getLog().info("Area: " + (Math.PI * radius * radius));
                getLog().info("Perimeter: " + (2 * Math.PI * radius));
                break;

            case "rectangle":
                getLog().info("Shape: Rectangle");
                getLog().info("Width: " + width + ", Height: " + height);
                getLog().info("Area: " + (width * height));
                getLog().info("Perimeter: " + (2 * (width + height)));
                break;

            case "triangle":
                getLog().info("Shape: Triangle");
                getLog().info("Sides: a=" + a + ", b=" + b + ", c=" + c);
                double perimeter = a + b + c;
                double s = perimeter / 2.0;
                double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                getLog().info("Area: " + area);
                getLog().info("Perimeter: " + perimeter);
                break;

            default:
                throw new MojoFailureException("Unknown shape: " + shape);
        }
    }
}