package dredonkey.extracomponents.components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.falsepattern.chromabeam.mod.BasicComponent;
import com.github.falsepattern.chromabeam.mod.BeamCollision;
import com.github.falsepattern.chromabeam.mod.Component;
import com.github.falsepattern.chromabeam.mod.interfaces.MaskedWorld;

public class AND extends BasicComponent {

    private int leftInput;
    private int rightInput;
    private int emitting;
    private int state;

    public AND() {
        super(1, "dredonkey.extracomponents.and", "extra");
    }

    @Override
    public BeamCollision processIncomingBeam(int beamHeading, int color, MaskedWorld world) {
        if(beamHeading == right)
            leftInput |= color;
        else if(beamHeading == left)
            rightInput |= color;
        return BeamCollision.CENTER;
    }

    @Override
    public void emitInitialBeams(MaskedWorld world) {
        if(emitting > 0)
            world.createBeam(rotation, emitting);
    }

    @Override
    public void componentUpdate() {
        emitting = leftInput & rightInput;
        state = (leftInput > 0 ? 1 : 0) + (rightInput > 0 ? 2 : 0) + (emitting > 0 ? 1 : 0);
        leftInput = 0;
        rightInput = 0;
    }

    @Override
    protected void cloneDataFromOriginal(Component original) {
        this.emitting = ((AND)original).emitting;
        this.state = ((AND)original).state;
    }

    @Override
    protected void serializeCustomData(Kryo kryo, Output output) {
        output.writeByte(emitting);
        output.writeByte(state);
    }

    @Override
    protected void deserializeCustomData(Kryo kryo, Input input) {
        emitting = input.readByte();
        state = input.readByte();
    }

    @Override
    public TextureRegion getTexture() {
        return texture[state];
    }
}
