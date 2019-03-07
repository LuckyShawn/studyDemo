package designpattern.bridge;

public interface ComputerBad {
	void sale();
}

class DesktopBad implements ComputerBad {
	@Override
	public void sale() {
		System.out.println("销售台式机！");
	}
}

class LaptopBad implements ComputerBad {
	@Override
	public void sale() {
		System.out.println("销售笔记本！");
	}
}
class Pad implements ComputerBad {
	@Override
	public void sale() {
		System.out.println("销售平板电脑！");
	}
}

class LenovoDesktopBad extends DesktopBad {
	@Override
	public void sale() {
		System.out.println("销售联想台式机");
	}
}
class LenovoLaptopBad extends LaptopBad {
	@Override
	public void sale() {
		System.out.println("销售联想笔记本");
	}
}
class LenovoPadBad extends Pad {
	@Override
	public void sale() {
		System.out.println("销售联想平板电脑");
	}
}



class ShenzhouDesktopBad extends DesktopBad {
	@Override
	public void sale() {
		System.out.println("销售神舟台式机");
	}
}
class ShenzhouLaptopBad extends LaptopBad {
	@Override
	public void sale() {
		System.out.println("销售神舟笔记本");
	}
}
class ShenzhouPadBad extends Pad {
	@Override
	public void sale() {
		System.out.println("销售神舟平板电脑");
	}
}


class DellDesktopBad extends DesktopBad {
	@Override
	public void sale() {
		System.out.println("销售戴尔台式机");
	}
}
class DellLaptopBad extends LaptopBad {
	@Override
	public void sale() {
		System.out.println("销售戴尔笔记本");
	}
}
class DellPadBad extends Pad {
	@Override
	public void sale() {
		System.out.println("销售戴尔平板电脑");
	}
}


