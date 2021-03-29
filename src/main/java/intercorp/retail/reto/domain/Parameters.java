package intercorp.retail.reto.domain;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class Parameters implements Serializable {

	private static final long serialVersionUID = -4961497597580715350L;
	private String key;
	private String value;
}
