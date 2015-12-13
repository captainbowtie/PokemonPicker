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
	private JButton[] buttons={new JButton("A"), new JButton("B")};
	private JPanel[] panels=new JPanel[2];
	private JLabel[] labels=new JLabel[2];
	private ImageIcon[] pictures=new ImageIcon[2];
	private ArrayList<Integer> currentNumbers = new ArrayList<Integer>();
	private ArrayList<Integer> nextNumbers = new ArrayList<Integer>();
	private Random randomNumbers = new Random();
	private int[] twoIndexes = new int[2];
	private int[] twoNumbers = new int[2];
	public  void startGUI(){
		setLayout(new GridLayout(2,2));
		for(int i=1;i<718;i++){
			currentNumbers.add(i);
		}
		twoIndexes[0]=randomNumbers.nextInt(717);
		twoNumbers[0]=currentNumbers.get(twoIndexes[0]);
		currentNumbers.remove(twoIndexes[0]);
		twoIndexes[1]=randomNumbers.nextInt(716);
		twoNumbers[1]=currentNumbers.get(twoIndexes[1]);
		currentNumbers.remove(twoIndexes[1]);
		buttons[0].addActionListener(new ButtonListener());
		buttons[1].addActionListener(new ButtonListener());
		pictures[0]=new ImageIcon(twoNumbers[0]+".png");
		pictures[1]=new ImageIcon(twoNumbers[1]+".png");
		labels[0]=new JLabel(pictures[0]);
		labels[1]=new JLabel(pictures[1]);
		panels[0]=new JPanel();
		panels[0].add(labels[0]);
		panels[1]=new JPanel();
		panels[1].add(labels[1]);
		add(panels[0]);
		add(panels[1]);
		add(buttons[0]);
		add(buttons[1]);
		pack();
		setVisible(true);
	}
	private void leftButton(){
		nextNumbers.add(twoNumbers[0]);
		nextTwo();
	}
	private void rightButton(){
		nextNumbers.add(twoNumbers[1]);
		nextTwo();
	}
	private void nextTwo(){
		setVisible(false);
		if(currentNumbers.size()<2){
			for(int i=0;i<nextNumbers.size();i++){
				currentNumbers.add(nextNumbers.get(i));
			}
			if(nextNumbers.size()<4){
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
		
		panels[0].remove(labels[0]);
		panels[1].remove(labels[1]);
		for(int i=0;i<2;i++){
			twoIndexes[i]=randomNumbers.nextInt(currentNumbers.size());
			twoNumbers[i]=currentNumbers.get(twoIndexes[i]);
			currentNumbers.remove(twoIndexes[i]);
			pictures[i]=new ImageIcon(twoNumbers[i]+".png");
			labels[i]=new JLabel(pictures[i]);
			panels[i].add(labels[i]);
			add(panels[i]);
		}
		add(buttons[0]);
		add(buttons[1]);
		pack();
		setVisible(true);


	}
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttons[0]){
				leftButton();
			}else if(e.getSource()==buttons[1]){
				rightButton();
			}

		}

	}
}
