package io.github.walterinsh.spring;

/**
 * Created by Walter on 8/13/16.
 */
public class AOPSpringBean {

    private CharSequence fieldNeedMocked = "foo";

    public CharSequence run(){
        return this.fieldNeedMocked;
    }

}
