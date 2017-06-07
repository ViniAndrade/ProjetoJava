package br.com.unipe;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import br.com.unipe.entidade.Estado;

/**
 * 
 * @author Alysson Alves.
 * 
 * @version 1.0.
 *
 */

@ManagedBean(name = "chartsBeans")
@ViewScoped
public class ChartsBeans implements Serializable {

	private LineChartModel graficoLinha;
	private BarChartModel graficoBarra;
	private HorizontalBarChartModel graficoBarraHorizontal;
	private CartesianChartModel graficoCartesiano;
	private BarChartModel graficoBalanca;
	private PieChartModel graficoPizza;
	private PieChartModel graficoVendasDosEstados;
	private List<Estado> estados;
	private Estado estado;

	private BarChartModel graficoLinhaFat;

	@PostConstruct
	public void init() {
	}

}
