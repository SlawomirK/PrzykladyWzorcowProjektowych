package czynnosciowe;

interface BrushState {
    void paint();
}

public class Stan {
    public static void main(String[] args) {
        var canvas = new PaintingCanvas(new SmallBrushState());
        canvas.paintLine();
        canvas.setState(new MediumBrushState());
        canvas.paintLine();
        canvas.paintLine();
        canvas.setState(new BigBrushState());
        canvas.paintLine();
    }
}

class SmallBrushState implements BrushState {


    @Override
    public void paint() {
        System.out.println("malowanie małym pędzelem");
    }
}

class MediumBrushState implements BrushState {

    @Override
    public void paint() {
        System.out.println("Malowanie średnim pędzlem");
    }
}

class BigBrushState implements BrushState {

    @Override
    public void paint() {
        System.out.println("Malowanie dużym pędzlem");
    }
}

class PaintingCanvas {
    private BrushState state;

    public PaintingCanvas(BrushState state) {
        this.state = state;
    }

    public void setState(BrushState state) {
        this.state = state;
    }

    public void paintLine() {
        this.state.paint();
    }
}