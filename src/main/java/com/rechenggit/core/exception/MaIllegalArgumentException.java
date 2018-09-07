package com.rechenggit.core.exception;

/**
 * 
 * <p>MA 参数检验异常</p>
 * @author netfinworks
 * @version $Id: MaIllegalArgumentException.java, v 0.1 2011-3-24 下午01:13:44 netfinworks Exp $
 */
public class MaIllegalArgumentException extends IllegalArgumentException {

    private static final long serialVersionUID = 4164067046709770426L;

    public MaIllegalArgumentException(String s) {
        super(s);
    }
    
    public MaIllegalArgumentException( String s, Exception cause ) {
        super(s);
        this.initCause(cause);
    }

}
