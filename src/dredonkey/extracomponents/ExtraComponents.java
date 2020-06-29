package dredonkey.extracomponents;

import com.github.falsepattern.chromabeam.core.AssetRegistry;
import com.github.falsepattern.chromabeam.core.ComponentRegistry;
import com.github.falsepattern.chromabeam.core.PostInitializationRegistry;
import com.github.falsepattern.chromabeam.mod.Mod;
import com.github.falsepattern.chromabeam.mod.interfaces.World;
import dredonkey.extracomponents.components.*;

public class ExtraComponents implements Mod {
    @Override
    public void initialization(ComponentRegistry registry) {
		registry.registerComponent(XOR.class);
		registry.registerComponent(AND.class);
    }

    @Override
    public void preInitialization(AssetRegistry registry) {
        registry.langRegistry.register("dredonkey.extracomponents.xor", "XOR gate");
        registry.langRegistry.register("dredonkey.extracomponents.and", "AND gate");
        registry.langRegistry.register("category.extra", "Extra");
        registry.textureRegistry.loadTexture("dredonkey.extracomponents.xor", "dredonkey/extracomponents/textures/xor.png", 5, 1);
        registry.textureRegistry.loadTexture("dredonkey.extracomponents.and", "dredonkey/extracomponents/textures/and.png", 5, 1);
    }

    @Override
    public void postInitialization(PostInitializationRegistry registry) {
    
    }

    @Override
    public void worldInitialization(World world) {
    }
	
	@Override
	public void shutdown() {
		
	}

    @Override
    public String getModid() {
        return "dredonkey.extracomponents";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }
}
