package io.github.pleuvoir.adapter.objects.more;

import io.github.pleuvoir.adapter.objects.more.monitor.HdmiMonitor;
import io.github.pleuvoir.adapter.objects.more.monitor.IVga;

public class Vga2HdmiAdapter implements IVga{
										//一头去接vga
	//一头接hdmi的显示器
	private HdmiMonitor hdmiMonitor;
	
	
	public Vga2HdmiAdapter(HdmiMonitor hdmiMonitor) {
		this.hdmiMonitor = hdmiMonitor;
	}

	// 适配逻辑
	@Override
	public void display() {
		hdmiMonitor.display();
	}

}
