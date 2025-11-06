package org.example.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "compute-geometry-3d")
public class My3DGeometryMojo extends AbstractMojo {

    @Parameter(property = "shape", defaultValue = "cube")
    private String shape;

    @Parameter(property = "side", defaultValue = "3")
    private double side;

    @Parameter(property = "radius", defaultValue = "5")
    private double radius;

    @Parameter(property = "height", defaultValue = "6")
    private double height;

    @Parameter(property = "width", defaultValue = "4")
    private double width;

    @Parameter(property = "depth", defaultValue = "5")
    private double depth;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        switch (shape.toLowerCase()) {
            case "cube":
                getLog().info("Shape: Cube");
                getLog().info("Side: " + side);
                double cubeVolume = Math.pow(side, 3);
                double cubeSurface = 6 * Math.pow(side, 2);
                getLog().info("Volume: " + cubeVolume);
                getLog().info("Surface Area: " + cubeSurface);
                break;

            case "sphere":
                getLog().info("Shape: Sphere");
                getLog().info("Radius: " + radius);
                double sphereVolume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
                double sphereSurface = 4 * Math.PI * Math.pow(radius, 2);
                getLog().info("Volume: " + sphereVolume);
                getLog().info("Surface Area: " + sphereSurface);
                break;

            case "cylinder":
                getLog().info("Shape: Cylinder");
                getLog().info("Radius: " + radius + ", Height: " + height);
                double cylinderVolume = Math.PI * Math.pow(radius, 2) * height;
                double cylinderSurface = 2 * Math.PI * radius * (radius + height);
                getLog().info("Volume: " + cylinderVolume);
                getLog().info("Surface Area: " + cylinderSurface);
                break;

            case "rectangularprism":
                getLog().info("Shape: Rectangular Prism");
                getLog().info("Width: " + width + ", Height: " + height + ", Depth: " + depth);
                double prismVolume = width * height * depth;
                double prismSurface = 2 * (width * height + width * depth + height * depth);
                getLog().info("Volume: " + prismVolume);
                getLog().info("Surface Area: " + prismSurface);
                break;

            default:
                throw new MojoFailureException("Unknown 3D shape: " + shape);
        }
    }
}