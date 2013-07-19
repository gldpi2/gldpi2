/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author greg
 */
public class GuidelineRateTableModel extends AbstractTableModel {

    private List<GuidelineRate> linhas;

    public GuidelineRateTableModel() {
        linhas = new ArrayList<>();
    }

    public GuidelineRateTableModel(List<GuidelineRate> guidelineList) {
        linhas = new ArrayList<>(guidelineList);
    }
    
    /*
    private String[] colunas = new String[]{"ID", "Tipo", "Categoria",
        "Demanda na ponta", "Demanda fora de ponta", "Ener seca de ponta",
        "Ener seca fora de ponta", "Ener umida de ponta", "Ener umida fora de ponta",
        "Valor ultrapassao", "Data"};
    private static final int idGuidelineRate = 0;
    private static final int guidelineRate = 1;
    private static final int category = 2;
    private static final int peakDemand = 3;
    private static final int outPeakDemand = 4;
    private static final int peakEnergyDry = 5;
    private static final int outPeakEnergyDry = 6;
    private static final int peakEnergyHumid = 7;
    private static final int outPeakEnergyHumid = 8;
    private static final int valueTranspassed = 9;
    private static final int timestamp = 10;
    */
    
    private String[] colunas = new String[]{"ID", "Tipo", "Categoria",
                                               "Data", /*"Registrado por"*/};
    
    private static final int idGuidelineRate = 0;
    private static final int guidelineRate = 1;
    private static final int category = 2;
    private static final int timestamp = 3;
    //private static final int user = 4;
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        GuidelineRate guideline = linhas.get(rowIndex);
//
//        private static final int idGuidelineRate = 0;
//    private static final int guidelineRate = 1;
//    private static final int category = 2;
//    private static final int peakDemand = 3;
//    private static final int outPeakDemand = 4;
//    private static final int peakEnergyDry = 5;
//    private static final int outPeakEnergyDry = 6;
//    private static final int peakEnergyHumid = 7;
//    private static final int outPeakEnergyHumid = 8;
//    private static final int valueTranspassed = 9;
//    private static final int timestamp = 10;

        /*
        switch (columnIndex) {
            case idGuidelineRate:
                return guideline.getIdGuidelineRate();
            case guidelineRate:
                return guideline.getGuidelineRate();
            case category:
                return guideline.getCategory();
            case peakDemand:
                return guideline.getPeakDemand();
            case outPeakDemand:
                return guideline.getOutPeakDemand();
            case peakEnergyDry:
                return guideline.getPeakEnergyDry();
            case outPeakEnergyDry:
                return guideline.getOutPeakEnergyDry();
            case peakEnergyHumid:
                return guideline.getPeakEnergyHumid();
            case outPeakEnergyHumid:
                return guideline.getOutPeakEnergyHumid();
            case valueTranspassed:
                return guideline.getValueTranspassed();
            case timestamp:
                return guideline.getTimestamp();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds!");
        }*/
        
        switch (columnIndex) {
            case idGuidelineRate:
                return guideline.getIdGuidelineRate();
            case guidelineRate:
                return guideline.getGuidelineRate();
            case category:
                return guideline.getCategory();
            case timestamp:
                return guideline.getTimestamp();
            //case user:
                //return user.
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds!");
        }
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        GuidelineRate g = linhas.get(rowIndex);

        /*
        switch (columnIndex) {
            case idGuidelineRate:
                g.setIdGuidelineRate((int) aValue);
                break;
            case guidelineRate:
                g.setGuidelineRate((String) aValue);
                break;
            case category:
                g.setCategory((String) aValue);
                break;
            case peakDemand:
                g.setPeakDemand((String) aValue);
                break;
            case outPeakDemand:
                g.setOutPeakDemand((String) aValue);
                break;
            case peakEnergyDry:
                g.setPeakEnergyDry((String) aValue);
                break;
            case outPeakEnergyDry:
                g.setOutPeakEnergyDry((String) aValue);
                break;
            case peakEnergyHumid:
                g.setPeakEnergyHumid((String) aValue);
                break;
            case outPeakEnergyHumid:
                g.setOutPeakEnergyHumid((String) aValue);
                break;
            case valueTranspassed:
                g.setValueTranspassed((String) aValue);
            case timestamp:
                g.setTimestamp((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds!");
        }*/
        
        switch (columnIndex) {
            case idGuidelineRate:
                g.setIdGuidelineRate((int) aValue);
                break;
            case guidelineRate:
                g.setGuidelineRate((String) aValue);
                break;
            case category:
                g.setCategory((String) aValue);
                break;
            case timestamp:
                g.setTimestamp((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds!");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public boolean cellSelectionEnabled(int rowIndex, int columnIndex) {
        return false;
    }

    public boolean rowSelectionAllowed() {
        return true;
    }

    public GuidelineRate getGuidelineRate(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addGuidelineRate(GuidelineRate guidelineRate) throws SQLException {
        // Adiciona o registro.
        linhas.add(guidelineRate);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeUser(int indiceLinha) throws SQLException {
        // Remove o registro.
        GuidelineRate guidelineRate = linhas.get(indiceLinha);
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addGuidelineRateList(List<GuidelineRate> guidelineRates) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(guidelineRates);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + guidelineRates.size());
    }

// Remove todos os registros.
    public void limpar() {
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}
