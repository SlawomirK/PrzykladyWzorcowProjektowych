package strukturalne;

interface Image {
    String render();
}

public class Proxy {
    public static void main(String[] args) {
        ProxyImage image1 = new ProxyImage("Image2x");
        ProxyImage image2 = new ProxyImage("Image3D");
        System.out.println(image1.render());
        System.out.println(image2.render());
    }
}

class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        this.loadImage();
    }

    public void loadImage() {
        System.out.println("ładowanie pliku " + this.filename);
    }

    public String render() {
        return "Zawartość obrazka " + this.filename;
    }
}

class ProxyImage implements Image {
    private final String filename;
    private Image image;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public String render() {
        if (this.image == null) {
            this.image = new RealImage(this.filename);
        }
        return this.image.render();
    }
}