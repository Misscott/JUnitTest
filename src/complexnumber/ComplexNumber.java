package complexnumber;

public class ComplexNumber {
	private int Real;
	private int Imaginary;

	public ComplexNumber(int re, int imag) {
		Real = re;
		Imaginary = imag;
	}

	public int getReal() {
		return Real;
	}

	public int getImaginary() {
		return Imaginary;
	}

	public ComplexNumber add(ComplexNumber c) {
		return new ComplexNumber(getReal() + c.getReal(), getImaginary() + c.getImaginary());
	}

	public ComplexNumber multiply(ComplexNumber c) {
		int re = getReal() * c.getReal() - getImaginary() * c.getImaginary();
		int imag = getImaginary() * c.getReal() + getReal() * c.getImaginary();
		return new ComplexNumber(re, imag);
	}

	@Override
	public boolean equals(Object anObject) {

		if (anObject == this) {
			return true;
		}
		if (anObject instanceof ComplexNumber) {
			ComplexNumber c = (ComplexNumber) anObject;
			return ((c.getReal() == getReal()) && (c.getImaginary() == getImaginary()));
		} else {
			return false;
		}
	}
}