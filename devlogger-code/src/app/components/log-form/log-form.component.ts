import { Component, OnInit } from '@angular/core';
import { LogService } from '../../services/log.service';
import { Log } from '../../model/Log';

@Component({
  selector: 'app-log-form',
  templateUrl: './log-form.component.html',
  styleUrls: ['./log-form.component.css']
})
export class LogFormComponent implements OnInit {

  constructor(private logService: LogService) { }
  id: string;
  title: string;
  date: Date;

  isNew: boolean = true;

  ngOnInit() {
    this.logService.selectedLog.subscribe(log => {
      if( log.id != null) {
        this.isNew = false;
        this.id = log.id;
        this.title = log.title;
        this.date = log.date;
      }
    })
  }


  onSubmit() {
    if(this.isNew) {
      const newLog = {
        id: this.getUUID(),
        title: this.title,
        date: new Date()

      };
      this.logService.addLog(newLog);
    } else {
      const updatedLog = {
        id: this.id,
        title: this.title,
        date: new Date()
      }
      this.logService.updatedLog(updatedLog);
    }


    this.clearState();
  }

  clearState() {
    this.isNew = true;
    this.id = null;
    this.title = null;
    this.date = null;
  }

  getUUID() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
      return v.toString(16);
    });
  }

}
