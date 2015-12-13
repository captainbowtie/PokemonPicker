/*
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    */

package com.allenbarr.PokemonPicker;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame{
	private JButton[] buttons={new JButton("0"), new JButton("1"),new JButton("2"),new JButton("3"),new JButton("4"),new JButton("5"),new JButton("6")};
	private JPanel[] panels=new JPanel[7];
	private JLabel[] labels=new JLabel[7];
	private ImageIcon[] pictures=new ImageIcon[7];
	private ArrayList<Integer> currentNumbers = new ArrayList<Integer>();
	private ArrayList<Integer> nextNumbers = new ArrayList<Integer>();
	private Random randomNumbers = new Random();
	private int[] sevenIndexes = new int[7];
	private int[] sevenNumbers = new int[7];
	public  void startGUI(){
		setLayout(new GridLayout(7,2));
		for(int i=1;i<718;i++){
			currentNumbers.add(i);
		}
		for(int i=0;i<7;i++){
			sevenIndexes[i]=randomNumbers.nextInt(717);
			sevenNumbers[i]=currentNumbers.get(sevenIndexes[i]);
			currentNumbers.remove(sevenIndexes[i]);
			buttons[i].addActionListener(new ButtonListener());
			pictures[i]= new ImageIcon(sevenNumbers[i]+".png");
			labels[i]= new JLabel(pictures[i]);
			panels[i]=new JPanel();
			panels[i].add(labels[i]);
			add(panels[i]);
			add(buttons[i]);
		}
		pack();
		setVisible(true);
	}
	private void button0(){
		nextNumbers.add(sevenNumbers[1]);
		nextNumbers.add(sevenNumbers[2]);
		nextNumbers.add(sevenNumbers[3]);
		nextNumbers.add(sevenNumbers[4]);
		nextNumbers.add(sevenNumbers[5]);
		nextNumbers.add(sevenNumbers[6]);
		nextSeven();
	}
	private void button1(){
		nextNumbers.add(sevenNumbers[0]);
		nextNumbers.add(sevenNumbers[2]);
		nextNumbers.add(sevenNumbers[3]);
		nextNumbers.add(sevenNumbers[4]);
		nextNumbers.add(sevenNumbers[5]);
		nextNumbers.add(sevenNumbers[6]);
		nextSeven();
	}
	private void button2(){
		nextNumbers.add(sevenNumbers[1]);
		nextNumbers.add(sevenNumbers[0]);
		nextNumbers.add(sevenNumbers[3]);
		nextNumbers.add(sevenNumbers[4]);
		nextNumbers.add(sevenNumbers[5]);
		nextNumbers.add(sevenNumbers[6]);
		nextSeven();
	}
	private void button3(){
		nextNumbers.add(sevenNumbers[1]);
		nextNumbers.add(sevenNumbers[2]);
		nextNumbers.add(sevenNumbers[0]);
		nextNumbers.add(sevenNumbers[4]);
		nextNumbers.add(sevenNumbers[5]);
		nextNumbers.add(sevenNumbers[6]);
		nextSeven();
	}
	private void button4(){
		nextNumbers.add(sevenNumbers[1]);
		nextNumbers.add(sevenNumbers[2]);
		nextNumbers.add(sevenNumbers[3]);
		nextNumbers.add(sevenNumbers[0]);
		nextNumbers.add(sevenNumbers[5]);
		nextNumbers.add(sevenNumbers[6]);
		nextSeven();
	}
	private void button5(){
		nextNumbers.add(sevenNumbers[1]);
		nextNumbers.add(sevenNumbers[2]);
		nextNumbers.add(sevenNumbers[3]);
		nextNumbers.add(sevenNumbers[4]);
		nextNumbers.add(sevenNumbers[0]);
		nextNumbers.add(sevenNumbers[6]);
		nextSeven();
	}
	private void button6(){
		nextNumbers.add(sevenNumbers[1]);
		nextNumbers.add(sevenNumbers[2]);
		nextNumbers.add(sevenNumbers[3]);
		nextNumbers.add(sevenNumbers[4]);
		nextNumbers.add(sevenNumbers[5]);
		nextNumbers.add(sevenNumbers[0]);
		nextSeven();
	}
	private void nextSeven(){
		setVisible(false);
		if(currentNumbers.size()<7){
			for(int i=0;i<nextNumbers.size();i++){
				currentNumbers.add(nextNumbers.get(i));
			}
			if(currentNumbers.size()<8){
				String numbersText="0";
				for(int i=0;i<currentNumbers.size();i++){
					numbersText=numbersText.concat(" "+currentNumbers.get(i));
				}
				NotificationWindow numbers = new NotificationWindow(numbersText);
			}
			while(nextNumbers.size()!=0){
				nextNumbers.remove(0);
			}
		}
		for(int i=0;i<7;i++){
			panels[i].remove(labels[i]);
			sevenIndexes[i]=randomNumbers.nextInt(currentNumbers.size());
			sevenNumbers[i]=currentNumbers.get(sevenIndexes[i]);
			currentNumbers.remove(sevenIndexes[i]);
			pictures[i]=new ImageIcon(sevenNumbers[i]+".png");
			labels[i]=new JLabel(pictures[i]);
			panels[i].add(labels[i]);
			add(panels[i]);
			add(buttons[i]);
		}
		pack();
		setVisible(true);


	}
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttons[0]){
				button0();
			}else if(e.getSource()==buttons[1]){
				button1();
			}else if(e.getSource()==buttons[2]){
				button2();
			}else if(e.getSource()==buttons[3]){
				button3();
			}else if(e.getSource()==buttons[4]){
				button4();
			}else if(e.getSource()==buttons[5]){
				button5();
			}else if(e.getSource()==buttons[6]){
				button6();
			}
		}
	}
}
