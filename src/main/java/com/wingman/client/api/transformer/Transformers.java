package com.wingman.client.api.transformer;

import com.wingman.client.classloader.transformers.*;
import com.wingman.client.classloader.transformers.mapping.RSMemberInjector;
import com.wingman.client.classloader.transformers.mapping.StaticsBridger;

import java.util.concurrent.CopyOnWriteArrayList;

public final class Transformers {

    /**
     * Contains transformers that can modify classes.
     * <p>
     * A transformer is only run on a class if the transformer is in the list before the class is loaded.
     * Transformers are run on RuneScape gamepack classes and classes in {@link com.wingman} and its sub-packages.
     * <p>
     * Should a plugin transformer want to transform a RuneScape class,
     * add it inside {@link com.wingman.client.api.plugin.Plugin.Setup}.
     */
    public static final CopyOnWriteArrayList<Transformer> TRANSFORMERS = new CopyOnWriteArrayList<>(new Transformer[] {
            /*
             * Mapping:
            */
            new RSMemberInjector(),
            new StaticsBridger(),

            /*
             * Client-listenable events:
            */
            new CanvasUpdatedTransformer(),

            /*
             * Plugin/client-listenable events:
            */
            new MessageReceivedTransformer(),
            new ItemDefinitionCachedTransformer(),
            new WidgetOpenedTransformer(),
            new ExperienceGainedTransformer(),
            new ExternalPlayerMovedTransformer(),
            new NpcUpdateTransformer(),

            /*
             * Code patches:
            */
            new PreserveExceptionInfoTransformer(),
    });

    public static void removeUnusedTransformers() {
        for (Transformer transformer : TRANSFORMERS) {
            if (!transformer.isUsed()) {
                TRANSFORMERS.remove(transformer);
            }
        }
    }

    private Transformers() {
        // This class should not be instantiated
    }
}
