package com.wingman.client.api.generated;

@SuppressWarnings("all")
public interface DualNode extends Node {
    void unlink();

    DualNode getNext();

    DualNode getPrevious();

    @SuppressWarnings("all")
    interface Unsafe extends Node {
        void setNext(DualNode value);

        void setPrevious(DualNode value);
    }
}
