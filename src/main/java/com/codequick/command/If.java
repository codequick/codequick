package com.codequick.command;

import com.codequick.Analizer;


// TODO complete the command (gt, lt, ge, le)
public class If implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {
		
		String[] operands = content.split(Analizer.parameter_separator);
		
		operands[1] = Analizer.removeStart(operands[1], new String[] {"\t"}, 0);
		if (operands.length == 3) {
			operands[2] = Analizer.removeStart(operands[2], new String[] {"\n"}, 0);
		}

		operands[1] = Analizer.removeEnd(operands[1], new String[] {"\t", "\n"}, 0);
		if (operands.length == 3) {
			operands[2] = Analizer.removeEnd(operands[2], new String[] {"\t", "\n"}, 0);
		}

		String[] conditions = operands[0].split(" ");
		
		boolean isNot = false;
		boolean or = false;
		String operand1 = null;
		String operand2 = null;
		String operator = null;
		boolean result = true;
		
		for (String condition : conditions) {
			if (condition.equals("not")) {
				isNot = true;
			} else if (condition.equals("and")) {
			} else if (condition.equals("or")) {
				or = true;
			} else if (condition.equals("eq") || condition.equals("ne") || condition.equals("gt") ||
					   condition.equals("lt") || condition.equals("ge") || condition.equals("le")) {
				operator = condition;
			} else {
				if (operand1 == null) {
					operand1 = condition;
				} else {
					operand2 = condition;
				}
			}
			
			if (operand1 != null && operand2 != null) {
				if (or) {
					result = result || operate(isNot, operator, operand1, operand2);
				} else {
					result = result && operate(isNot, operator, operand1, operand2);
				}
				or = isNot = false;
				operator = operand1 = operand2 = null;
			}
		}

		if (operand1 != null) {
			if (or) {
				result = result || operate(isNot, operator, operand1, operand2);
			} else {
				result = result && operate(isNot, operator, operand1, operand2);
			}
		}

		return result ? operands[1] : (operands.length == 3 ? operands[2] : "");
		
	}
	
	private boolean operate (boolean isNot, String operator, String operand1, String operand2) {
		if (operand2 == null) {
			return isNot ? !Boolean.valueOf(operand1) : Boolean.valueOf(operand1);
		} else {
			if (operator.equals("eq")) {
				return isNot ? !operand1.equals(operand2) : operand1.equals(operand2);
			} else if (operator.equals("ne")) {
				return isNot ? operand1.equals(operand2) : !operand1.equals(operand2);
			}
		}
		return false;
	} 

}
