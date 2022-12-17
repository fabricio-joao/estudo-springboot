package com.estudo.springBoot.enuns;

public enum PedidoStatus {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;

	private PedidoStatus(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
     
	public static PedidoStatus valorOf(int codigo) {
		for(PedidoStatus p: PedidoStatus.values()) {
			if(p.getCodigo() == codigo) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Codifo inexistente");
	}
	
	
}
